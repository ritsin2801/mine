import React, {useEffect, useState} from 'react'
import {Text,View,StyleSheet,TextInput,TouchableOpacity} from 'react-native'
import { useNavigation, useRoute } from '@react-navigation/native'
import {openDatabase} from 'react-native-sqlite-storage';
let db=openDatabase({name: 'userDatabase2.db'});


const UpdateUser=()=>{

    const route = useRoute();

    const navigation=useNavigation();
    const [name,setName]=useState('');
    const [phone,setPhone]=useState('');
    const [landline,setLandline]=useState('');
    
    useEffect(()=>{
        setName(route.params.data.name);
        setName(route.params.data.phone);
        setName(route.params.data.landline);
        //setName(route.params.data.id);

        
    }, []);

    const updateData=()=>{
        db.transaction(txn=>{
            txn.executeSql('UPDATE table_user set name=?, phone=?, landline=? where id=?',
            [name, phone, landline,route.params.data.id],
            (tx,res) => {
                navigation.goBack();
             },
            );
        });
    };


    return(
        <View>
            <TextInput
            style={styles.textInput}
            placeholder='name'
            value={name}
            onChangeText={(text)=>setName(text)}
            />

           <TextInput
            style={styles.textInput}
            placeholder='phone'
            value={phone}
            onChangeText={(text)=>setPhone(text)}
            />

           <TextInput
            style={styles.textInput}
            placeholder='ladline'
            value={landline}
            onChangeText={(text)=>setLandline(text)}
            />
         <TouchableOpacity onPress={()=>{
             updateData();
         }}>
             <Text style={{ fontSize: 22, color: 'orange' }}>Update user</Text>
         </TouchableOpacity>

        </View>
    );


};

export default UpdateUser;

const styles=StyleSheet.create({
    textInput:{
        fontsize: 18,
        color: 'blue',
        borderWidth:2,
        borderColor: 'blue',
        margin: 10
    }
  })
  