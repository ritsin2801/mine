import {ADD_ITEM} from './constants';
export const addItem=(item)=>(
    {
      type:ADD_ITEM,
      data: item
    }
)