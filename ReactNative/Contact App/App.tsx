/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

 import React from 'react';
 import {NavigationContainer} from '@react-navigation/native';
 import { createNativeStackNavigator } from '@react-navigation/native-stack'; 
 //import { createStackNavigator } from '@react-navigation/native-stack';
 import AddNewUser from './AddNewUser';
 import Main from './Main';
import UpdateUser from './UpdateUser';
import SearchContact from './SearchContact';

 //import { NavigationContainer } from '@react-navigation/native';
 
 const Stack = createNativeStackNavigator();
 
 export default function App() {

  return(
   <NavigationContainer>
     <Stack.Navigator>
       <Stack.Screen
         name="Main"
         component={Main}
         options={{
           title: 'Contact-List',
           headerTintColor: 'orange',
           headerStyle: {
             backgroundColor: 'black'
           }
         }}
       />
       <Stack.Screen
         name="AddNewUser"
         component={AddNewUser}
         options={{
           headerTintColor: 'orange',
           headerStyle: {
             backgroundColor: 'black'
           }
         }}
       />
          
           <Stack.Screen
         name="UpdateUser"
         component={UpdateUser}
         options={{
           headerTintColor: 'orange',
           headerStyle: {
             backgroundColor: 'black'
           }
         }}
       />  
        <Stack.Screen
         name="SearchContact"
         component={SearchContact}
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

 //export default App;
