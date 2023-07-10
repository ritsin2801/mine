
import {ADD_ITEM} from './constants';
const initialState=[];
export const reducer=(state=initialState,action)=>{
    switch(action.type){
        case ADD_ITEM:
            return[
                ...state,
                action.data
            ]

            default:
                return state

    }

}