/*
 * This file was autogenerated by genconsts.py
 *
 * LINSTOR - management of distributed storage/DRBD9 resources
 * Copyright (C) 2017 - 2018  LINBIT HA-Solutions GmbH
 * Author: Robert Altnoeder, Roland Kammerer, Gabor Hernadi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.linbit.linstor.api;

@SuppressWarnings({"checkstyle:magicnumber", "checkstyle:constantname"})
public class ApiConsts
{
    /*
     * Bits 62 - 63 (most significant 2) are reserved for the message type masks (error, warning, info)
     * Bits 25 - 26 are reserved for the operation type masks (create, modify, delete)
     * Bits 15 - 18 are reserved for the object type masks (node, resource, resource definition, ...)
     * Bits 0  - 14 are reserved for codes
     */
    public static final long MASK_ERROR = 0xC000000000000000L;
    public static final long MASK_WARN = 0x8000000000000000L;
    public static final long MASK_INFO = 0x4000000000000000L;
    public static final long MASK_SUCCESS = 0x0000000000000000L;

    /*
     * Operation type masks
     */
    public static final long MASK_CRT = 0x0000000001000000L;
    public static final long MASK_MOD = 0x0000000002000000L;
    public static final long MASK_DEL = 0x0000000003000000L;

    /*
     * Type masks (Node, ResDfn, Res, VolDfn, Vol, NetInterface, ...)
     */
    public static final long MASK_NODE = 0x00000000003C0000L;
    public static final long MASK_RSC_DFN = 0x0000000000380000L;
    public static final long MASK_RSC = 0x0000000000340000L;
    public static final long MASK_VLM_DFN = 0x0000000000300000L;
    public static final long MASK_VLM = 0x00000000002C0000L;
    public static final long MASK_NODE_CONN = 0x0000000000280000L;
    public static final long MASK_RSC_CONN = 0x0000000000240000L;
    public static final long MASK_VLM_CONN = 0x0000000000200000L;
    public static final long MASK_NET_IF = 0x00000000001C0000L;
    public static final long MASK_STOR_POOL_DFN = 0x0000000000180000L;
    public static final long MASK_STOR_POOL = 0x0000000000140000L;
    public static final long MASK_CTRL_CONF = 0x0000000000100000L;

    /*
     * Codes 1-9: success
     */
    public static final long CREATED = 1 | MASK_SUCCESS;
    public static final long DELETED = 2 | MASK_SUCCESS;
    public static final long MODIFIED = 3 | MASK_SUCCESS;
    public static final long PASSPHRASE_ACCEPTED = 4 | MASK_SUCCESS;

    /*
     * Codes 100 - 999: failures
     */

    /*
     * Codes 100 - 199: sql failures
     */
    public static final long FAIL_SQL = 100 | MASK_ERROR;
    public static final long FAIL_SQL_ROLLBACK = 101 | MASK_ERROR;

    /*
     * Codes 200-299: invalid * failures
     */
    public static final long FAIL_INVLD_NODE_NAME = 200 | MASK_ERROR;
    public static final long FAIL_INVLD_NODE_TYPE = 201 | MASK_ERROR;
    public static final long FAIL_INVLD_RSC_NAME = 202 | MASK_ERROR;
    public static final long FAIL_INVLD_RSC_PORT = 203 | MASK_ERROR;
    public static final long FAIL_INVLD_NODE_ID = 204 | MASK_ERROR;
    public static final long FAIL_INVLD_VLM_NR = 205 | MASK_ERROR;
    public static final long FAIL_INVLD_VLM_SIZE = 206 | MASK_ERROR;
    public static final long FAIL_INVLD_MINOR_NR = 207 | MASK_ERROR;
    public static final long FAIL_INVLD_STOR_POOL_NAME = 208 | MASK_ERROR;
    public static final long FAIL_INVLD_NET_NAME = 209 | MASK_ERROR;
    public static final long FAIL_INVLD_NET_ADDR = 210 | MASK_ERROR;
    public static final long FAIL_INVLD_NET_PORT = 211 | MASK_ERROR;
    public static final long FAIL_INVLD_NET_TYPE = 212 | MASK_ERROR;
    public static final long FAIL_INVLD_PROP = 213 | MASK_ERROR;
    public static final long FAIL_INVLD_TRANSPORT_TYPE = 214 | MASK_ERROR;
    public static final long FAIL_INVLD_TCP_PORT = 215 | MASK_ERROR;
    public static final long FAIL_INVLD_CRYPT_PASSPHRASE = 216 | MASK_ERROR;
    public static final long FAIL_INVLD_ENCRYPT_TYPE = 217 | MASK_ERROR;

    /*
     * Codes 300-399: dependency not found failures
     */
    public static final long FAIL_NOT_FOUND_NODE = 300 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_RSC_DFN = 301 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_RSC = 302 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_VLM_DFN = 303 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_VLM = 304 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_NET_IF = 305 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_NODE_CONN = 306 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_RSC_CONN = 307 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_VLM_CONN = 308 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_STOR_POOL_DFN = 309 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_STOR_POOL = 310 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_DFLT_STOR_POOL = 311 | MASK_ERROR;
    public static final long FAIL_NOT_FOUND_CRYPT_KEY = 312 | MASK_ERROR;

    /*
     * Codes 400-499: access denied failures
     */
    public static final long FAIL_ACC_DENIED_NODE = 400 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_RSC_DFN = 401 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_RSC = 402 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_VLM_DFN = 403 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_VLM = 404 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_STOR_POOL_DFN = 405 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_STOR_POOL = 406 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_NODE_CONN = 407 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_RSC_CONN = 408 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_VLM_CONN = 409 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_STLT_CONN = 410 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_CTRL_CFG = 411 | MASK_ERROR;
    public static final long FAIL_ACC_DENIED_COMMAND = 412 | MASK_ERROR;

    /*
     * Codes 500-599: data already exists failures
     */
    public static final long FAIL_EXISTS_NODE = 500 | MASK_ERROR;
    public static final long FAIL_EXISTS_RSC_DFN = 501 | MASK_ERROR;
    public static final long FAIL_EXISTS_RSC = 502 | MASK_ERROR;
    public static final long FAIL_EXISTS_VLM_DFN = 503 | MASK_ERROR;
    public static final long FAIL_EXISTS_VLM = 504 | MASK_ERROR;
    public static final long FAIL_EXISTS_NET_IF = 505 | MASK_ERROR;
    public static final long FAIL_EXISTS_NODE_CONN = 506 | MASK_ERROR;
    public static final long FAIL_EXISTS_RSC_CONN = 507 | MASK_ERROR;
    public static final long FAIL_EXISTS_VLM_CONN = 508 | MASK_ERROR;
    public static final long FAIL_EXISTS_STOR_POOL_DFN = 509 | MASK_ERROR;
    public static final long FAIL_EXISTS_STOR_POOL = 510 | MASK_ERROR;
    public static final long FAIL_EXISTS_STLT_CONN = 511 | MASK_ERROR;
    public static final long FAIL_EXISTS_CRYPT_PASSPHRASE = 512 | MASK_ERROR;

    /*
     * Codes 600-699: data missing failures
     */
    public static final long FAIL_MISSING_PROPS = 600 | MASK_ERROR;
    public static final long FAIL_MISSING_PROPS_NETCOM_TYPE = 601 | MASK_ERROR;
    public static final long FAIL_MISSING_PROPS_NETCOM_PORT = 602 | MASK_ERROR;
    public static final long FAIL_MISSING_NETCOM = 603 | MASK_ERROR;
    public static final long FAIL_MISSING_PROPS_NETIF_NAME = 604 | MASK_ERROR;
    public static final long FAIL_MISSING_STLT_CONN = 605 | MASK_ERROR;

    /*
     * Codes 700-799: uuid mismatch failures
     */
    public static final long FAIL_UUID_NODE = 700 | MASK_ERROR;
    public static final long FAIL_UUID_RSC_DFN = 701 | MASK_ERROR;
    public static final long FAIL_UUID_RSC = 702 | MASK_ERROR;
    public static final long FAIL_UUID_VLM_DFN = 703 | MASK_ERROR;
    public static final long FAIL_UUID_VLM = 704 | MASK_ERROR;
    public static final long FAIL_UUID_NET_IF = 705 | MASK_ERROR;
    public static final long FAIL_UUID_NODE_CONN = 706 | MASK_ERROR;
    public static final long FAIL_UUID_RSC_CONN = 707 | MASK_ERROR;
    public static final long FAIL_UUID_VLM_CONN = 708 | MASK_ERROR;
    public static final long FAIL_UUID_STOR_POOL_DFN = 709 | MASK_ERROR;
    public static final long FAIL_UUID_STOR_POOL = 710 | MASK_ERROR;

    /*
     * Codes 800-899: number pools exhausted
     */
    public static final long FAIL_POOL_EXHAUSTED_VLM_NR = 800 | MASK_ERROR;
    public static final long FAIL_POOL_EXHAUSTED_MINOR_NR = 801 | MASK_ERROR;
    public static final long FAIL_POOL_EXHAUSTED_TCP_PORT = 802 | MASK_ERROR;
    public static final long FAIL_POOL_EXHAUSTED_NODE_ID = 803 | MASK_ERROR;

    /*
     * Other failures
     */
    public static final long FAIL_NOT_ENOUGH_NODES = 996 | MASK_ERROR;
    public static final long FAIL_IN_USE = 997 | MASK_ERROR;
    public static final long FAIL_UNKNOWN_ERROR = 998 | MASK_ERROR;
    public static final long FAIL_IMPL_ERROR = 999 | MASK_ERROR;

    /*
     * Codes 1000-1999: warnings
     */
    public static final long WARN_INVLD_OPT_PROP_NETCOM_ENABLED = 1001 | MASK_WARN;
    public static final long WARN_NOT_CONNECTED = 1002 | MASK_WARN;
    public static final long WARN_STLT_NOT_UPDATED = 1003 | MASK_WARN;
    public static final long WARN_NO_STLT_CONN_DEFINED = 1004 | MASK_WARN;
    public static final long WARN_DEL_UNSET_PROP = 1005 | MASK_WARN;
    public static final long WARN_NOT_FOUND = 3000 | MASK_WARN;

    /*
     * Special codes
     */
    public static final long UNKNOWN_API_CALL = 0x0FFFFFFFFFFFFFFFL | MASK_ERROR;
    public static final long API_CALL_AUTH_REQ = 0x0FFFFFFFFFFFFFFEL | MASK_ERROR;

    /*
     * SignIn codes
     */
    public static final long RC_SIGNIN_PASS = 10000 | MASK_SUCCESS;
    public static final long RC_SIGNIN_FAIL = 10000 | MASK_ERROR;
    public static final String API_REPLY = "Reply";

    /*
     * Create object APIs
     */
    public static final String API_CRT_NODE = "CrtNode";
    public static final String API_CRT_RSC = "CrtRsc";
    public static final String API_CRT_RSC_DFN = "CrtRscDfn";
    public static final String API_CRT_NET_IF = "CrtNetIf";
    public static final String API_CRT_VLM_DFN = "CrtVlmDfn";
    public static final String API_CRT_SNPSHT = "CrtSnpsht";
    public static final String API_CRT_STOR_POOL_DFN = "CrtStorPoolDfn";
    public static final String API_CRT_STOR_POOL = "CrtStorPool";
    public static final String API_CRT_NODE_CONN = "CrtNodeConn";
    public static final String API_CRT_RSC_CONN = "CrtRscConn";
    public static final String API_CRT_VLM_CONN = "CrtVlmConn";
    public static final String API_AUTO_PLACE_RSC = "AutoPlaceRsc";
    public static final String API_CRT_CRYPT_PASS = "CrtCryptPass";

    /*
     * Modify object APIs
     */
    public static final String API_MOD_NODE = "ModNode";
    public static final String API_MOD_NODE_CONN = "ModNodeConn";
    public static final String API_MOD_RSC = "ModRsc";
    public static final String API_MOD_RSC_CONN = "ModRscConn";
    public static final String API_MOD_RSC_DFN = "ModRscDfn";
    public static final String API_MOD_NET_IF = "ModNetIf";
    public static final String API_MOD_STOR_POOL = "ModStorPool";
    public static final String API_MOD_STOR_POOL_DFN = "ModStorPoolDfn";
    public static final String API_MOD_VLM_DFN = "ModVlmDfn";
    public static final String API_MOD_VLM = "ModVlm";
    public static final String API_MOD_VLM_CONN = "ModVlmConn";
    public static final String API_MOD_SNPSHT = "ModSnpsht";
    public static final String API_MOD_CRYPT_PASS = "ModCryptPass";

    /*
     * Delete object APIs
     */
    public static final String API_DEL_NODE = "DelNode";
    public static final String API_DEL_RSC = "DelRsc";
    public static final String API_DEL_RSC_DFN = "DelRscDfn";
    public static final String API_DEL_NET_IF = "DelNetIf";
    public static final String API_DEL_VLM_DFN = "DelVlmDfn";
    public static final String API_DEL_STOR_POOL_DFN = "DelStorPoolDfn";
    public static final String API_DEL_STOR_POOL = "DelStorPool";
    public static final String API_DEL_NODE_CONN = "DelNodeConn";
    public static final String API_DEL_RSC_CONN = "DelRscConn";
    public static final String API_DEL_VLM_CONN = "DelVlmConn";
    public static final String API_DEL_SNPSHT = "DelSnpsht";
    public static final String API_DEL_CRYPT_PASS = "DelCryptPass";
    public static final String API_RST_SNPSHT = "RstSnpsht";
    public static final String API_AUTO_DPLY_RSC = "AutoDplyRsc";
    public static final String API_LOST_NODE = "LostNode";
    public static final String API_CHK_STATE = "ChkState";

    /*
     * Authentication APIs
     */
    public static final String API_SIGN_IN = "SignIn";
    public static final String API_VERSION = "Version";

    /*
     * Debug APIs
     */
    public static final String API_CRT_DBG_CNSL = "CrtDbgCnsl";
    public static final String API_DSTR_DBG_CNSL = "DstrDbgCnsl";

    /*
     * Command APIs
     */
    public static final String API_CONTROL_CTRL = "ControlCtrl";
    public static final String API_CMD_SHUTDOWN = "Shutdown";

    /*
     * List object APIs
     */
    public static final String API_LST_NODE = "LstNode";
    public static final String API_LST_RSC = "LstRsc";
    public static final String API_LST_RSC_DFN = "LstRscDfn";
    public static final String API_LST_NET_IF = "LstNetIf";
    public static final String API_LST_VLM_DFN = "LstVlmDfn";
    public static final String API_LST_VLM = "LstVlm";
    public static final String API_LST_SNPSHT = "LstSnpsht";
    public static final String API_LST_STOR_POOL = "LstStorPool";
    public static final String API_LST_STOR_POOL_DFN = "LstStorPoolDfn";

    /*
     * Event APIs
     */
    public static final String API_CRT_WATCH = "CrtWatch";
    public static final String API_CANCEL_WATCH = "CancelWatch";
    public static final String API_EVENT = "Event";
    public static final String API_RPT_SPC = "RptSpc";
    public static final String API_PING = "Ping";
    public static final String API_PONG = "Pong";
    public static final String API_MOD_INF = "ModInf";
    public static final String API_VSN_INF = "VsnInf";
    public static final String API_SET_CFG_VAL = "SetCfgVal";
    public static final String API_DEL_CFG_VAL = "DelCfgVal";
    public static final String API_LST_CFG_VAL = "LstCfgVal";

    /*
     * Encryption APIs
     */
    public static final String API_ENTER_CRYPT_PASS = "EnterCryptPass";

    /*
     * Control APIs
     */
    public static final String API_SHTDWN = "Shtdwn";

    /*
     * Events
     */
    public static final String EVENT_VOLUME_DISK_STATE = "VlmDiskState";
    public static final String EVENT_RESOURCE_STATE = "ResourceState";

    /*
     * Object property keys
     */
    public static final String KEY_UUID = "UUID";
    public static final String KEY_NODE = "Node";
    public static final String KEY_RSC_DFN = "RscDfn";
    public static final String KEY_STOR_POOL_DFN = "StorPoolDfn";
    public static final String KEY_1ST_NODE = "FirstNode";
    public static final String KEY_2ND_NODE = "SecondNode";
    public static final String KEY_NODE_NAME = "NodeName";
    public static final String KEY_NODE_TYPE = "NodeType";
    public static final String KEY_NODE_FLAGS = "NodeFlags";
    public static final String KEY_NODE_ID = "NodeId";
    public static final String KEY_1ST_NODE_NAME = "FirstNodeName";
    public static final String KEY_2ND_NODE_NAME = "SecondNodeName";
    public static final String KEY_RSC_NAME = "RscName";
    public static final String KEY_STOR_POOL_NAME = "StorPoolName";
    public static final String KEY_NET_IF_NAME = "NetIfName";
    public static final String KEY_SNPSHT_NAME = "SnpshtName";
    public static final String KEY_VLM_NR = "VlmNr";
    public static final String KEY_VLM_SIZE = "VlmSize";
    public static final String KEY_MINOR_NR = "MinorNr";
    public static final String KEY_PEER_COUNT = "PeerCount";
    public static final String KEY_AL_SIZE = "AlSize";
    public static final String KEY_AL_STRIPES = "AlStripes";
    public static final String KEY_ID = "ID";
    public static final String KEY_ROLE = "Role";
    public static final String KEY_MISSING_NAMESPC = "MissingNameSpace";

    /*
     * Property namespaces
     */
    public static final String NAMESPC_NETCOM = "NetCom";
    public static final String NAMESPC_DFLT = "Default";
    public static final String NAMESPC_LOGGING = "Logging";
    public static final String NAMESPC_ALLOC = "Allocation";
    public static final String NAMESPC_NETIF = "NetIf";
    public static final String NAMESPC_STLT = "Satellite";
    public static final String NAMESPC_STORAGE_DRIVER = "StorDriver";
    public static final String NAMESPC_AUXILIARY = "Aux";
    public static final String NAMESPC_DRBD_OPTIONS = "DrbdOptions";
    public static final String NAMESPC_DRBD_NET_OPTIONS = "DrbdOptions/Net";
    public static final String NAMESPC_DRBD_DISK_OPTIONS = "DrbdOptions/Disk";
    public static final String NAMESPC_DRBD_RESOURCE_OPTIONS = "DrbdOptions/Resource";
    public static final String NAMESPC_DRBD_PEER_DEVICE_OPTIONS = "DrbdOptions/PeerDevice";

    /*
     * Storage pool property keys
     */
    public static final String KEY_STOR_POOL_VOLUME_GROUP = "LvmVg";
    public static final String KEY_STOR_POOL_THIN_POOL = "ThinPool";
    public static final String KEY_STOR_POOL_ZPOOL = "ZPool";
    public static final String KEY_STOR_POOL_PREF_NIC = "PrefNic";
    public static final String KEY_STOR_POOL_CRYPT_PASSWD = "CryptPasswd";

    /*
     * Storage pool traits keys
     */
    public static final String KEY_STOR_POOL_SUPPORTS_SNAPSHOTS = "SupportsSnapshots";

    /*
     * Property keys
     */
    public static final String KEY_PORT_NR = "PortNr";
    public static final String KEY_IP_ADDR = "IPAddr";
    public static final String KEY_BIND_ADDR = "BindAddr";
    public static final String KEY_NETCOM_TYPE = "NetComType";
    public static final String KEY_NETIF_NAME = "NetIfName";
    public static final String KEY_NETIF_TYPE = "NetIfType";
    public static final String KEY_NETCOM_ENABLED = "NetComEnabled";
    public static final String KEY_KEYSTORE = "Keystore";
    public static final String KEY_TRUSTSTORE = "Truststore";
    public static final String KEY_KEY_PWD = "KeyPwd";
    public static final String KEY_KEYSTORE_PWD = "KeystorePwd";
    public static final String KEY_TRUSTSTORE_PWD = "TruststorePwd";
    public static final String KEY_SSL_PROTO = "SslProto";
    public static final String KEY_TCP_PORT_AUTO_RANGE = "TcpPortAutoRange";
    public static final String KEY_MINOR_NR_AUTO_RANGE = "MinorNrAutoRange";
    public static final String KEY_CUR_STLT_CONN_NAME = "CurStltConnName";

    /*
     * Property values
     */
    public static final String VAL_NETCOM_TYPE_SSL = "SSL";
    public static final String VAL_NETCOM_TYPE_PLAIN = "Plain";
    public static final String VAL_SSL_PROTO_TLSv1 = "TLSv1";

    /*
     * Node Type values
     */
    public static final String VAL_NODE_TYPE_CTRL = "Controller";
    public static final String VAL_NODE_TYPE_STLT = "Satellite";
    public static final String VAL_NODE_TYPE_CMBD = "Combined";
    public static final String VAL_NODE_TYPE_AUX = "Auxiliary";

    /*
     * Net interface Type values
     */
    public static final String VAL_NETIF_TYPE_IP = "IP";
    public static final String VAL_NETIF_TYPE_RDMA = "RDMA";
    public static final String VAL_NETIF_TYPE_ROCE = "RoCE";

    /*
     * Authentication keys
     */
    public static final String KEY_SEC_IDENTITY = "SecIdentity";
    public static final String KEY_SEC_ROLE = "SecRole";
    public static final String KEY_SEC_TYPE = "SecType";
    public static final String KEY_SEC_DOMAIN = "SecDomain";
    public static final String KEY_SEC_PASSWORD = "SecPassword";

    /*
     * Default ports
     */
    public static final int DFLT_CTRL_PORT_SSL = 3377;
    public static final int DFLT_CTRL_PORT_PLAIN = 3376;
    public static final int DFLT_STLT_PORT_PLAIN = 3366;

    /*
     * Boolean values
     */
    public static final String VAL_TRUE = "True";
    public static final String VAL_FALSE = "False";

    /*
     * Flag string values
     */
    public static final String FLAG_CLEAN = "CLEAN";
    public static final String FLAG_DELETE = "DELETE";
    public static final String FLAG_DISKLESS = "DISKLESS";
    public static final String FLAG_QIGNORE = "QIGNORE";
    public static final String FLAG_ENCRYPTED = "ENCRYPTED";

    private ApiConsts()
    {
    }
}
