import React, {useEffect, useState} from 'react'
import {Text,View,StyleSheet,TextInput,TouchableOpacity} from 'react-native'
import { useNavigation } from '@react-navigation/native'
import {openDatabase} from 'react-native-sqlite-storage';
let db=openDatabase({name: 'userDatabase2.db'});

const AddNewUser=()=>{
    const navigation=useNavigation();
    const [name,setName]=useState('');
    const [phone,setPhone]=useState('');
    const [landline,setLandline]=useState('');

    useEffect(() => {
        db.transaction((txn) => {
          txn.executeSql(
            "SELECT name FROM sqlite_master WHERE type='table' AND name='table_user' ",
            [],
             (tx, res)=>{
              console.log('item:', res.rows.length);
              if (res.rows.length == 0) {
                txn.executeSql('DROP TABLE IF EXISTS Table_user', []);
                txn.executeSql(
                  'CREATE TABLE IF NOT EXISTS Table_user(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(30), phone INT(15), landline INT(15))',
                  [],
                );
              } else {
                  console.log("already craeted");
              }
            },
          );
        });
     
      }, []);

      const saveData=()=>{
          db.transaction((txt) => {
        txt.executeSql(
            'INSERT INTO Table_user( name, phone, landline) VALUES(?,?,?)',
            [name, phone, landline],
            (tex,res)=>{
                if(res.rowsAffected==1){
                    navigation.goBack();
                }else{
                    console.log(res);
                }
                
            },
            error => {
                console.log(error);
            }
          );
          });
      };

    return(
        <View>
            <Text style={{ fontSize: 22, color: '#5fc9f8' }}>Enter name:</Text>
            <TextInput
            style={styles.textInput}
            placeholder='name'
            value={name}
            onChangeText={(text)=>setName(text)}
            />
           <Text style={{ fontSize: 22, color: '#5fc9f8' }}>Mobile No.</Text>
           <TextInput
           style={styles.textInput}
            placeholder='phone'
            value={phone}
            onChangeText={(text)=>setPhone(text)}
            />
             <Text style={{ fontSize: 22, color: '#5fc9f8' }}>landline No:</Text>
           <TextInput
           style={styles.textInput}
            placeholder='ladline'
            value={landline}
            onChangeText={(text)=>setLandline(text)}
            />
         <TouchableOpacity onPress={()=>{
             saveData();
         }}>
             <Text style={{ fontSize: 22, color: 'black' }}>Save Cotact</Text>
         </TouchableOpacity>

        </View>
    );

};

export default AddNewUser;


const styles=StyleSheet.create({
  textInput:{
      fontsize: 18,
      color: 'blue',
      borderWidth:2,
      borderColor: 'blue',
      margin: 10
  }
})
