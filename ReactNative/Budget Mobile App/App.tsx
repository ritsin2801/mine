/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

 import React from 'react';
 import { createNativeStackNavigator } from '@react-navigation/native-stack'; 
 import Input from './Input';
 import ItemList from './ItemList';
 import { NavigationContainer } from '@react-navigation/native';
 
 const Stack = createNativeStackNavigator();
 
 const App = () =>{

  return(
   <NavigationContainer>
     <Stack.Navigator>
       <Stack.Screen
         name="Input"
         component={Input}
         options={{
           title: 'Add Item',
           headerTintColor: 'orange',
           headerStyle: {
             backgroundColor: 'black'
           }
         }}
       />
       <Stack.Screen
         name="ItemList"
         component={ItemList}
         options={{
           headerTintColor: 'orange',
           headerStyle: {
             backgroundColor: 'black'
           }
         }}
       />
     </Stack.Navigator>
   </NavigationContainer>
  );
   };

   export default App;