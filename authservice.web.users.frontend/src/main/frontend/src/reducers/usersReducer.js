import { createReducer } from 'redux-starter-kit';
import { emptyUser, emptyUserAndPasswords, emptyRole, emptyPermission } from '../constants';
import { USERS_RECEIVED } from '../actiontypes';

const usersReducer = createReducer([], {
    [USERS_RECEIVED]: (state, action) => {
        const users = action.payload;
        users.unshift(emptyUser);
        return users;
    },
});

export default usersReducer;
