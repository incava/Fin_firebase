package com.incava.fin_firebase
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.incava.fin_firebase.Model.ChatModel
import com.incava.fin_firebase.Model.Personinfo
import com.incava.fin_firebase.adapter.PersonAdapter
import com.incava.fin_firebase.databinding.FragmentChatBinding

class Chat2Fragment : Fragment() {

    private var personinfo =  mutableListOf<Personinfo>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentChatBinding.inflate(inflater,container,false)
        var personAdapter = PersonAdapter()
        view.RecyclerItem.adapter = personAdapter
        val database = Firebase.database
        val myID:String = "ingi"
        //val myRef = database.getReference("User")
        //myRef.child("ingi").child("name").setValue("최인기")
        //myRef.child("ingi").child("email").setValue("ingi1118@naver.com")
        //val myRef = database.getReference("ChatRooms").child("info")
        val myRef = database.getReference("ChatRooms").child(myID)
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //personinfo.clear()
                for(data in snapshot.children){
                    val item = data.getValue<Personinfo>()
                    //Log.d(tag,item.toString())
                    //if(item?.uid.equals(myUid)) { continue } // 본인은 친구창에서 제외
                    personAdapter.UpdateUseritem(item!!)
                    //Toast.makeText(activity,personinfo.toString(),Toast.LENGTH_LONG).show()
                }
                personAdapter.notifyDataSetChanged()
                Toast.makeText(activity,personinfo.toString(),Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })
        var student = HashMap<String,ChatModel>()
        student.put("ingi1",Personinfo())
        //myRef.child("info").setValue(personinfo)
        //personinfo.add(Personinfo("ingi1112@naver.com","최인기2","www.naver.com2","2호"))
        //personinfo.add(Personinfo("ingi1113@naver.com","최인기3","www.naver.com3","3호"))
        //personinfo.add(Personinfo("ingi1114@naver.com","최인기4","www.naver.com4","4호"))
        //database.getReference("User").child("info").setValue(student)
        personinfo.clear()
        //student.put("ingi4",Personinfo("ingi1114@naver.com","최인기4","www.naver.com4","4호"))
        //database.getReference("User").child("info").setValue(student)

        personAdapter.setOnItemClickListener(object : PersonAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: Personinfo, pos : Int) {
                Toast.makeText(activity,"체크확인",Toast.LENGTH_SHORT).show()
            }
        })
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }

}


