package com.iggroup.webapi.samples.client.rest.dto.getDealConfirmationV1;
/*
Describes the error (or success) condition for the specified trading operation
*/
public enum Reason {

/*
The account is not enabled to trade
*/
ACCOUNT_NOT_ENABLED_TO_TRADING,
/*
The level of the attached stop or limit is not valid
*/
ATTACHED_ORDER_LEVEL_ERROR,
/*
The trailing stop value is invalid
*/
ATTACHED_ORDER_TRAILING_STOP_ERROR,
/*
Cannot change the stop type.
*/
CANNOT_CHANGE_STOP_TYPE,
/*
Cannot remove the stop.
*/
CANNOT_REMOVE_STOP,
/*
We are not taking opening deals on a Controlled Risk basis on this market
*/
CLOSING_ONLY_TRADES_ACCEPTED_ON_THIS_MARKET,
/*
Resubmitted request does not match the original order.
*/
CONFLICTING_ORDER,
/*
Instrument has an error; please contact Support
*/
CONTACT_SUPPORT_INSTRUMENT_ERROR,
/*
Sorry we are unable to process this order.
 The stop or limit level you have requested is not a valid trading level in the underlying market.
*/
CR_SPACING,
/*
The order has been rejected as it is a duplicate of a previously issued order
*/
DUPLICATE_ORDER_ERROR,
/*
Exchange check failed. Please call in for assistance.
*/
EXCHANGE_MANUAL_OVERRIDE,
/*
Order expiry is less than the sprint market's minimum expiry.
 Check the sprint market's market details for the allowable expiries.
*/
EXPIRY_LESS_THAN_SPRINT_MARKET_MIN_EXPIRY,
/*
The total size of deals placed on this market in a short period has exceeded our limits.
 Please wait before attempting to open further positions on this market.
*/
FINANCE_REPEAT_DEALING,
/*
Ability to force open in different currencies on same market not allowed
*/
FORCE_OPEN_ON_SAME_MARKET_DIFFERENT_CURRENCY,
/*
an error has occurred but no detailed information is available.
 Check transaction history or contact support for further information
*/
GENERAL_ERROR,
/*
The working order has been set to expire on a past date
*/
GOOD_TILL_DATE_IN_THE_PAST,
/*
The requested market was not found
*/
INSTRUMENT_NOT_FOUND,
/*
The account has not enough funds available for the requested trade
*/
INSUFFICIENT_FUNDS,
/*
The market level has moved and has been rejected
*/
LEVEL_TOLERANCE_ERROR,
/*
The deal has been rejected because the limit level is inconsistent with current market price given the direction.
*/
LIMIT_ORDER_WRONG_SIDE_OF_MARKET,
/*
The manual order timeout limit has been reached
*/
MANUAL_ORDER_TIMEOUT,
/*
Order declined during margin checks
 Check available funds.
*/
MARGIN_ERROR,
/*
The market is currently closed
*/
MARKET_CLOSED,
/*
The market is currently closed with edits
*/
MARKET_CLOSED_WITH_EDITS,
/*
The epic is due to expire shortly, client should deal in the next available contract.
*/
MARKET_CLOSING,
/*
The market does not allow opening shorting positions
*/
MARKET_NOT_BORROWABLE,
/*
The market is currently offline
*/
MARKET_OFFLINE,
/*
The epic does not support 'Market' order type
*/
MARKET_ORDERS_NOT_ALLOWED_ON_INSTRUMENT,
/*
The market can only be traded over the phone
*/
MARKET_PHONE_ONLY,
/*
The market has been rolled to the next period
*/
MARKET_ROLLED,
/*
The requested market is not allowed to this account
*/
MARKET_UNAVAILABLE_TO_CLIENT,
/*
The order size exceeds the instrument's maximum configured value for auto-hedging the exposure of a deal
*/
MAX_AUTO_SIZE_EXCEEDED,
/*
The order size is too small
*/
MINIMUM_ORDER_SIZE_ERROR,
/*
The limit level you have requested is closer to the market level than the existing stop.
 When the market is closed you can only move the limit order further away from the current market level.
*/
MOVE_AWAY_ONLY_LIMIT,
/*
The stop level you have requested is closer to the market level than the existing stop level.
 When the market is closed you can only move the stop level further away from the current market level
*/
MOVE_AWAY_ONLY_STOP,
/*
The order level you have requested is moving closer to the market level than the exisiting order level.
 When the market is closed you can only move the order further away from the current market level.
*/
MOVE_AWAY_ONLY_TRIGGER_LEVEL,
/*
Opening CR position in opposite direction to existing CR position not allowed.
*/
OPPOSING_DIRECTION_ORDERS_NOT_ALLOWED,
/*
The deal has been rejected to avoid having long and short open positions on the same market
 or having long and short open positions and working orders on the same epic
*/
OPPOSING_POSITIONS_NOT_ALLOWED,
/*
Order declined; please contact Support
*/
ORDER_DECLINED,
/*
The order is locked and cannot be edited by the user
*/
ORDER_LOCKED,
/*
The order has not been found
*/
ORDER_NOT_FOUND,
/*
The total position size at this stop level is greater than the size allowed on this market.
 Please reduce the size of the order.
*/
OVER_NORMAL_MARKET_SIZE,
/*
Position cannot be deleted as it has been partially closed.
*/
PARTIALY_CLOSED_POSITION_NOT_DELETED,
/*
The deal has been rejected because of an existing position.
 Either set the 'force open' to be true or cancel opposing position
*/
POSITION_ALREADY_EXISTS_IN_OPPOSITE_DIRECTION,
/*
Position cannot be cancelled.
 Check transaction history or contact support for further information.
*/
POSITION_NOT_AVAILABLE_TO_CANCEL,
/*
Cannot close this position. Either the position no longer exists, or the size available to close is less than the size specified.
*/
POSITION_NOT_AVAILABLE_TO_CLOSE,
/*
The position has not been found
*/
POSITION_NOT_FOUND,
/*
Invalid attempt to submit a CFD trade on a spreadbet account
*/
REJECT_CFD_ORDER_ON_SPREADBET_ACCOUNT,
/*
Invalid attempt to submit a spreadbet trade on a CFD account
*/
REJECT_SPREADBET_ORDER_ON_CFD_ACCOUNT,
/*
Order size is not an increment of the value specified for the market.
*/
SIZE_INCREMENT,
/*
The expiry of the position would have fallen after the closing time of the market
*/
SPRINT_MARKET_EXPIRY_AFTER_MARKET_CLOSE,
/*
The market does not allow stop or limit attached orders
*/
STOP_OR_LIMIT_NOT_ALLOWED,
/*
The order requires a stop
*/
STOP_REQUIRED_ERROR,
/*
The submitted strike level is invalid
*/
STRIKE_LEVEL_TOLERANCE,
/*
The operation completed successfully
*/
SUCCESS,
/*
The market or the account do not allow for trailing stops
*/
TRAILING_STOP_NOT_ALLOWED,
/*
The operation resulted in an unknown result condition.
 Check transaction history or contact support for further information
*/
UNKNOWN,
/*
The requested operation has been attempted on the wrong direction
*/
WRONG_SIDE_OF_MARKET
}
