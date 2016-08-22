package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2;
/*

*/
public enum AuthenticationStatus {

/*
The user was logged in successfully and an account was impersonated
*/
AUTHENTICATED,
/*
The user is successfully authenticated with missing credentials.
 In this case the user will not be able to set the default account.
*/
AUTHENTICATED_MISSING_CREDENTIALS,
/*
The login was good but the front end must switch environments and re-apply using a silent login token via the CST.
 Where this is returned: the CST header will contain a temporary token for the new environment. There will be no X-SECURITY-TOKEN (treat as a null).
 This temporary CST MUST be passed to the silent login service after which a brand new and proper CST will be returned along with an X-SECURITY-TOKEN.
 <p/>
 <ol>
 <li>Dealer attempts a login using typical v2 auth service (no tokens required for this)</li>
 <li>Login response is CHANGE_ENVIRONMENT with the target in response property <code>redirectTo</code> AND a temporary token in CST header</li>
 <li>Front end changes to new environment and passes CST header to silent login service</li>
 <li>Response contains the dealers proper details AND a new CST AND an X-SECURITY-TOKEN</li>
 </ol>
*/
CHANGE_ENVIRONMENT,
/*
The authentication process cannot be completed because the user is now required to specify a different preferred account,
 This happens when the previously defined preferred account is no longer allowed to login, hence the user is now required to operate a new selection of his preferred account in order to proceed.
*/
DISABLED_PREFERRED_ACCOUNT,
/*
The authentication process cannot be completed because the user is now required to specify his preferred account,
 This happens when a user owns more than one account with IG and these have been migrated to the new client/account model.
 The migration process could not determine which account should be used as the preferred one, hence the user is prompted to make a decision at this stage.
*/
MISSING_PREFERRED_ACCOUNT,
/*
The request was rejected for one of the following reasons:
 The dealer must be shown a hard custom message
 The dealer is using a deprecated client
*/
REJECTED_INVALID_CLIENT_VERSION
}
