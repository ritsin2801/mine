import {View,Text,StyleSheet,TouchableOpacity,FlatList,Alert,Image} from 'react-native';
import React, {useEffect, useState} from 'react';
//import { useNavigation } from '@react-navigation/native';
//import AddNewUser from './AddNewUser';
import { useIsFocused, useNavigation } from '@react-navigation/native';
import {openDatabase} from 'react-native-sqlite-storage';
let db=openDatabase({name: 'userDatabase2.db'});

const Main=()=>{
    const [userList, setUserList]=useState('');
    const navigation=useNavigation();
    const isFocused=useIsFocused();

    
    useEffect(() =>{
      getData();
}, [isFocused]);

   const getData=()=>{
    db.transaction(txn=>{
        txn.executeSql('SELECT * FROM table_user', [], (tx,res)=>{
            let temp=[];

        for(let i=0;i<res.rows.length;++i){
            console.log(res.rows.item(i));
            temp.push(res.rows.item(i));
        }
        setUserList(temp);
        });
    });
   };

  const deleteUser=id=>{
      db.transaction(txn =>{
          txn.executeSql('DELETE FROM table_user where id=?',[id], (tx,res)=>{
            getData();
          },
        );
      });
  };

    return(
        <View>
            <FlatList
             data={userList}
             renderItem={({item, index}) =>{
                 return(
                     <TouchableOpacity style={{margin:10, padding:10}}>
                         <Text>{item.name}</Text>
                         <Text>{item.phone}</Text>
                         <Text>{item.landline}</Text>
                         <View style ={{flexDirection:'row'}}>
                             <TouchableOpacity onPress={()=> {
                             navigation.navigate('UpdateUser', {
                               data: {
                                   name:item.name,
                                   phone: item.phone,
                                   landline: item.landline,
                                   id: item.id
                               }, 
                            });
                              } }>
                                 <Text style={{margin:10,padding:10,color:'blue'}}>edit</Text>
                             </TouchableOpacity>

                             <TouchableOpacity onPress={()=>{
                                 deleteUser(item.id);
                             }}>
                                 <Text style={{margin:10,padding:10,color:'red'}}>dalete</Text>
                             </TouchableOpacity>

                             
                         </View>


                     </TouchableOpacity>

                 );
             }}
            />
            <TouchableOpacity
            onPress={()=>{navigation.navigate('AddNewUser')}}>
                <Text style={{ fontSize: 22, color: 'green' }}>Add New User</Text>
            </TouchableOpacity>

            <TouchableOpacity 
            onPress = {()=>{navigation.navigate('SearchContact')}}>
            <Text style={{ fontSize: 22, color: 'orange' }}>Search</Text>
             </TouchableOpacity>
        </View>
    );
};

export default Main;