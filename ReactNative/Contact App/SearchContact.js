import React, { useState } from 'react';
import { Text, View, SafeAreaView, TextInput, TouchableOpacity, StyleSheet} from 'react-native';
import { openDatabase } from 'react-native-sqlite-storage';

var db = openDatabase({ name: 'UserDatabase2.db' });

const Search=()=>{

    let [inputname, setInputname] = useState('');
  let [userData, setUserData] = useState({});

  let searchUser = () => {
    console.log(inputname);
    setUserData({});
    db.transaction((tx) => {
      tx.executeSql(
        'SELECT * FROM table_user where name = ?',
        [inputname],
        (tx, results) => {
          var len = results.rows.length;
          console.log('len', len);
          if (len > 0) {
            setUserData(results.rows.item(0));
          } else {
            alert('No user found');
          }
        }
      );
    });
  };

  return (
    <SafeAreaView style={{ flex: 1 }}>
      <View style={{ flex: 1, backgroundColor: 'white' }}>
        <View style={{ flex: 1 }}>
          <TextInput
          style={styles.textInput}

            placeholder="Enter contact name"
            value={inputname}
            onChangeText={
              (text) => setInputname(text)
            }
          />
          
          <TouchableOpacity onPress={()=>{
              searchUser();
          }}>
              <Text style={{ fontSize: 22, color: 'blue' }}>Search Contact</Text>
          </TouchableOpacity>

          <View
            >
            <Text>{userData.name}</Text>
            <Text>{userData.phone}</Text>
            <Text>{userData.landline}</Text>
          </View>
        </View>
       
       
      </View>
    </SafeAreaView>
  );

};

export default Search;


const styles=StyleSheet.create({
  textInput:{
      fontsize: 18,
      color: 'blue',
      borderWidth:2,
      borderColor: 'blue',
      margin: 10
  }
})