import React,{useState} from 'react';
import {Text,TextInput,View,TouchableOpacity,StyleSheet} from 'react-native';
import { addItem } from './actions';
import { useDispatch } from 'react-redux';
const Input=({ navigation })=>{
    const [name,setName]=useState('');
    const [actualprice,setActualprice]=useState('');
    const [plannedprice,setPlannedprice]=useState('');
    const dispatch = useDispatch();

    const SubmitItem = (props) => {
      const item=props.item;
      if (name && actualprice && plannedprice) {
        dispatch(addItem(item))
        setName('')
        setActualprice('')
        setPlannedprice('')
      }
    }
    return(
        <View>
         <Text>Helllo</Text>
         <TextInput
         style={styles.textInput}
        placeholder='Enter Product Name'
        onChangeText={(text)=>setName(text)}
        value={name} />
        <TextInput
         style={styles.textInput}
         placeholder='Actual price'
         onChangeText={(text)=>setActualprice(text)}
        value={actualprice}
         />
        <TextInput
        style={styles.textInput}
        placeholder='Planned price' 
        onChangeText={(text)=>setPlannedprice(text)}
        value={plannedprice}/>

<TouchableOpacity
        style={{ marginBottom: 16 }}
        onPress={() => {
          SubmitItem(item)
          //setName('')
        }}>
        <Text style={{ fontSize: 22, color: '#5fc9f8' }}>Submit</Text>
      </TouchableOpacity>
      <TouchableOpacity
        style={{ marginBottom: 16 }}
        onPress={() =>
          navigation.navigate('ItemList')}>
        <Text style={{ fontSize: 22, color: 'white' }}>Go to ITEM_List</Text>
      </TouchableOpacity> 

        </View>
        
    );
};

const styles=StyleSheet.create({
    textInput:{
        fontsize: 18,
        color: 'blue',
        borderWidth:2,
        borderColor: 'blue',
        margin: 10
    }
})

export default Input;