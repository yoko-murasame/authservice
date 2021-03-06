import { createReducer } from '@reduxjs/toolkit';
import { emptyRole } from '../constants';
import { ROLE_UPDATE } from '../actiontypes';

const roleReducer = createReducer({ ...emptyRole }, {
    [ROLE_UPDATE]: (state, action) => {
        const role = action.payload;
        return role;
    },
});

export default roleReducer;
