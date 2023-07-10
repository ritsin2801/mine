import React from 'react';
import {
    Text,
  StyleSheet,
  FlatList,
  View
} from 'react-native';

import {  useSelector } from 'react-redux';

const ItemList=()=>{
    const items = useSelector(state => state.reducer);

    return(
        <View style={styles.container}>
            <FlatList 
              data={items}
              renderItem={({item, index}) =>{
                  return( 
                     <View style={styles.item}  >
                         <Text>{item.name}</Text>
                         <Text>{item.actualprice}</Text>
                         <Text>{item.plannedprice}</Text>   
                      </View>


                  )
              }}/>
        </View>
    );

};

export default ItemList;

const styles=StyleSheet.create({
    container: {  
        flexdirection: 'row'  
    },

    item: {  
        padding: 10,  
        fontSize: 18,  
        height: 44,  
    },  
})