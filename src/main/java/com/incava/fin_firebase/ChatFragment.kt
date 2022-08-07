package com.incava.fin_firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.incava.fin_firebase.Model.Personinfo
import com.incava.fin_firebase.Model.PersonAdapter
import com.incava.fin_firebase.Model.PersonViewModel
import com.incava.fin_firebase.databinding.FragmentChatBinding
import kotlin.random.Random

class ChatFragment : Fragment() {
    val database = Firebase.database
    private lateinit var personAdapter:PersonAdapter
    private var binding: FragmentChatBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentChatBinding.inflate(inflater, container, false)
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentChatBinding = FragmentChatBinding.bind(view)
        binding = fragmentChatBinding
        personAdapter = PersonAdapter()
        fragmentChatBinding.RecyclerItem.adapter = personAdapter
        observerData()

        view.findViewById<Button>(R.id.button_Tolist).setOnClickListener{
            val myRef = database.getReference("User")
            var random = (1..100).random()
            myRef.child("ingi$random").setValue(Personinfo("ingi1112@naver.com","최인기2","www.naver.com2","2호"))
        }

        //

        //val myRef = database.getReference("User")
        //myRef.child("ingi").child("name").setValue("최인기")
        //myRef.child("ingi").child("email").setValue("ingi1118@naver.com")
        //val myRef = database.getReference("ChatRooms").child("info")
        //val myRef = database.getReference("User").child("info")
        //myRef.addValueEventListener(object : ValueEventListener {
        //    override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //personinfo.clear()
        //        for (data in snapshot.children) {
        //            val item = data.getValue<Personinfo>()
                    //Log.d(tag,item.toString())
                    //if(item?.uid.equals(myUid)) { continue } // 본인은 친구창에서 제외
        //            personAdapter.UpdateUseritem(item!!)
                    //Toast.makeText(activity,personinfo.toString(),Toast.LENGTH_LONG).show()
       //        }
        //        personAdapter.notifyDataSetChanged()
                //Toast.makeText(activity, personinfo.toString(), Toast.LENGTH_SHORT).show()
        //    }

        //    override fun onCancelled(error: DatabaseError) {
        //        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        //    }
//
        //})
       // val myID = "ingi"
        //var student = HashMap<String, Personinfo>()
        //val myRef2 = database.getReference("ChatRoom").child("info")
        //student.put("ingi1", Personinfo("ingi1112@naver.com", "최인기2", "www.naver.com2", "2호"))
        //myRef.child("info").setValue(personinfo)
        //personinfo.add(Personinfo("ingi1112@naver.com","최인기2","www.naver.com2","2호"))
        //personinfo.add(Personinfo("ingi1113@naver.com","최인기3","www.naver.com3","3호"))
        //personinfo.add(Personinfo("ingi1114@naver.com","최인기4","www.naver.com4","4호"))
        //database.getReference("User").child("info").setValue(student)
        //personinfo.clear()
        //student.put("ingi4",Personinfo("ingi1114@naver.com","최인기4","www.naver.com4","4호"))
        //database.getReference("User").child("info").setValue(student)
        personAdapter.setOnItemClickListener(object : PersonAdapter.OnItemClickListener {
            override fun onItemClick(v: View, data: Personinfo, pos: Int) {
                //Toast.makeText(activity, "체크확인", Toast.LENGTH_SHORT).show()
                val bundles = bundleOf("name" to data.name)
                //Toast.makeText(activity, "체크${data.name}", Toast.LENGTH_LONG).show()
                // val action = MainFragmentDirections.actionMainScreenToSearchScreen()
                //findNavController().navigate(action)
                Navigation.findNavController(view).navigate(R.id.action_chatFragment_to_messageFragment,bundles)
                //findNavController().navigate(R.id.action_chatFragment_to_messageFragment)
            }
            })
    }
    private fun observerData(){
        PersonViewModel().fetchData().observe(viewLifecycleOwner, Observer {
            personAdapter.setListData(it)
        })
    }
}


