/*
Navicat MySQL Data Transfer

Source Server         : localConnection
Source Server Version : 50637
Source Host           : localhost:3000
Source Database       : dais_db

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-11-03 16:12:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `total` decimal(16,8) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for accountoperation
-- ----------------------------
DROP TABLE IF EXISTS `accountoperation`;
CREATE TABLE `accountoperation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `symbol` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `amount` decimal(16,10) DEFAULT NULL,
  `fees` decimal(16,10) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1转入，2转出',
  `status` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `touserid` int(11) DEFAULT NULL,
  `ishomeshow` tinyint(1) DEFAULT '1',
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统资金流向';

-- ----------------------------
-- Table structure for autowithdrawauth
-- ----------------------------
DROP TABLE IF EXISTS `autowithdrawauth`;
CREATE TABLE `autowithdrawauth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `withdraw_opration_id` int(11) DEFAULT NULL,
  `symbol` int(11) DEFAULT NULL,
  `status` int(3) DEFAULT NULL COMMENT '用作定时任务处理提现判断 1未处理， 2已处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for captualoperationpush
-- ----------------------------
DROP TABLE IF EXISTS `captualoperationpush`;
CREATE TABLE `captualoperationpush` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `operationid` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '1未推送，2推送失败,3已推送成功',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `retry_times` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for captualoperationsync
-- ----------------------------
DROP TABLE IF EXISTS `captualoperationsync`;
CREATE TABLE `captualoperationsync` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coin_name` varchar(50) DEFAULT NULL,
  `operation_id` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `symbol` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `amount` decimal(16,8) DEFAULT NULL,
  `fees` decimal(16,8) DEFAULT NULL,
  `opertion_type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `last_updatetime` datetime DEFAULT NULL,
  `withdraw_virtual_address` varchar(100) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `recharge_virtual_address` varchar(100) DEFAULT NULL,
  `ftradeUniqueNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for chatroommsg
-- ----------------------------
DROP TABLE IF EXISTS `chatroommsg`;
CREATE TABLE `chatroommsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `content` text,
  `headimg` varchar(128) DEFAULT NULL,
  `msg_type` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for coin_trade_rank
-- ----------------------------
DROP TABLE IF EXISTS `coin_trade_rank`;
CREATE TABLE `coin_trade_rank` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `high` decimal(10,5) DEFAULT NULL,
  `low` decimal(10,5) DEFAULT NULL,
  `last` decimal(10,5) DEFAULT NULL,
  `vol` decimal(20,6) DEFAULT NULL,
  `buy` decimal(10,5) DEFAULT NULL,
  `sell` decimal(10,5) DEFAULT NULL,
  `trade_time` int(20) DEFAULT NULL,
  `price_flu` varchar(20) DEFAULT NULL COMMENT '涨跌幅，该字段一般用不上，为了方便，现在数据库预留',
  `coin_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for coin_trade_rank_day
-- ----------------------------
DROP TABLE IF EXISTS `coin_trade_rank_day`;
CREATE TABLE `coin_trade_rank_day` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `high` decimal(10,5) DEFAULT NULL,
  `low` decimal(10,5) DEFAULT NULL,
  `last` decimal(10,5) DEFAULT NULL,
  `vol` decimal(20,6) DEFAULT NULL,
  `buy` decimal(10,5) DEFAULT NULL,
  `sell` decimal(10,5) DEFAULT NULL,
  `trade_time` int(20) DEFAULT NULL,
  `price_flu` varchar(20) DEFAULT NULL COMMENT '涨跌幅，该字段一般用不上，为了方便，现在数据库预留',
  `coin_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for coin_trade_rank_hour
-- ----------------------------
DROP TABLE IF EXISTS `coin_trade_rank_hour`;
CREATE TABLE `coin_trade_rank_hour` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `high` decimal(10,5) DEFAULT NULL,
  `low` decimal(10,5) DEFAULT NULL,
  `last` decimal(10,5) DEFAULT NULL,
  `vol` decimal(20,6) DEFAULT NULL,
  `buy` decimal(10,5) DEFAULT NULL,
  `sell` decimal(10,5) DEFAULT NULL,
  `trade_time` int(20) DEFAULT NULL,
  `price_flu` varchar(20) DEFAULT NULL COMMENT '涨跌幅，该字段一般用不上，为了方便，现在数据库预留',
  `coin_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for coin_trade_rank_min5
-- ----------------------------
DROP TABLE IF EXISTS `coin_trade_rank_min5`;
CREATE TABLE `coin_trade_rank_min5` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `high` decimal(10,5) DEFAULT NULL,
  `low` decimal(10,5) DEFAULT NULL,
  `last` decimal(10,5) DEFAULT NULL,
  `vol` decimal(20,6) DEFAULT NULL,
  `buy` decimal(10,5) DEFAULT NULL,
  `sell` decimal(10,5) DEFAULT NULL,
  `trade_time` int(20) DEFAULT NULL,
  `price_flu` varchar(20) DEFAULT NULL COMMENT '涨跌幅，该字段一般用不上，为了方便，现在数据库预留',
  `coin_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for common_params
-- ----------------------------
DROP TABLE IF EXISTS `common_params`;
CREATE TABLE `common_params` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `param_key` varchar(255) DEFAULT NULL COMMENT '参数的key值',
  `param_value` varchar(255) DEFAULT NULL COMMENT '参数的值',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fcountlimit
-- ----------------------------
DROP TABLE IF EXISTS `fcountlimit`;
CREATE TABLE `fcountlimit` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `fIp` varchar(64) DEFAULT NULL,
  `fCreateTime` datetime DEFAULT NULL,
  `fCount` int(11) DEFAULT NULL,
  `fType` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='重试登陆错误次数之类的用';

-- ----------------------------
-- Table structure for fees
-- ----------------------------
DROP TABLE IF EXISTS `fees`;
CREATE TABLE `fees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `minfees` decimal(16,8) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `maxfees` decimal(16,8) DEFAULT NULL,
  `symbol` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `coinname` varchar(50) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `rate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='交易手续费';

-- ----------------------------
-- Table structure for ffees
-- ----------------------------
DROP TABLE IF EXISTS `ffees`;
CREATE TABLE `ffees` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `ffee` decimal(16,6) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `withdraw` decimal(16,6) DEFAULT NULL,
  `fvir_id` int(11) DEFAULT NULL,
  `flevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=gb2312 COMMENT='交易手续费';

-- ----------------------------
-- Table structure for fmessage
-- ----------------------------
DROP TABLE IF EXISTS `fmessage`;
CREATE TABLE `fmessage` (
  `FId` int(11) NOT NULL AUTO_INCREMENT,
  `FStatus` int(1) DEFAULT NULL,
  `FTitle` varchar(100) DEFAULT NULL,
  `FContent` varchar(500) DEFAULT NULL,
  `FReceiverId` int(11) DEFAULT NULL,
  `FCreatorId` int(11) DEFAULT NULL,
  `FCreateTime` datetime DEFAULT NULL,
  `operationid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fpool
-- ----------------------------
DROP TABLE IF EXISTS `fpool`;
CREATE TABLE `fpool` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fvi_type` int(11) DEFAULT NULL,
  `faddress` varchar(256) DEFAULT NULL,
  `fstatus` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `fvir_fk` (`fvi_type`),
  KEY `status_fk` (`fstatus`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fquestion
-- ----------------------------
DROP TABLE IF EXISTS `fquestion`;
CREATE TABLE `fquestion` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `ftype` int(11) DEFAULT NULL,
  `fdesc` text,
  `ftelephone` varchar(32) DEFAULT NULL,
  `fuid` int(11) DEFAULT NULL,
  `fstatus` int(11) DEFAULT NULL,
  `fcreateTime` datetime DEFAULT NULL,
  `fsolveTime` datetime DEFAULT NULL,
  `faid` int(11) DEFAULT NULL,
  `fname` varchar(32) DEFAULT NULL,
  `fanswer` text,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fvalidatemessage
-- ----------------------------
DROP TABLE IF EXISTS `fvalidatemessage`;
CREATE TABLE `fvalidatemessage` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `FUs_fId` int(11) DEFAULT NULL,
  `fPhone` varchar(32) DEFAULT NULL,
  `fContent` text,
  `fStatus` int(11) DEFAULT NULL,
  `type` tinyint(4) DEFAULT '0' COMMENT '0短信|1语音',
  `fCreateTime` datetime DEFAULT NULL,
  `fSendTime` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='需要发送的短信，status：0未发送，1已经发送';

-- ----------------------------
-- Table structure for fvirtualaddress
-- ----------------------------
DROP TABLE IF EXISTS `fvirtualaddress`;
CREATE TABLE `fvirtualaddress` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `fVi_fId` int(11) DEFAULT NULL,
  `fAdderess` varchar(180) DEFAULT NULL,
  `fuid` int(11) DEFAULT NULL,
  `fCreateTime` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `fname` varchar(30) DEFAULT NULL COMMENT '钱包名称',
  PRIMARY KEY (`fId`),
  UNIQUE KEY `fAdderess_seq__` (`fAdderess`) USING BTREE,
  UNIQUE KEY `fuid_fvid` (`fuid`,`fVi_fId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='虚拟钱包地址，用于导入和导出虚拟币';

-- ----------------------------
-- Table structure for fvirtualaddress_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `fvirtualaddress_withdraw`;
CREATE TABLE `fvirtualaddress_withdraw` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `fVi_fId` int(11) DEFAULT NULL,
  `flabel` varchar(50) DEFAULT NULL,
  `fAdderess` varchar(128) DEFAULT NULL,
  `fuid` int(11) DEFAULT NULL,
  `fCreateTime` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `init` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='虚拟钱包地址，用于导入和导出虚拟币';

-- ----------------------------
-- Table structure for fvirtualcaptualoperation
-- ----------------------------
DROP TABLE IF EXISTS `fvirtualcaptualoperation`;
CREATE TABLE `fvirtualcaptualoperation` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `FUs_fId2` int(11) DEFAULT NULL,
  `fVi_fId2` int(11) DEFAULT NULL,
  `fCreateTime` datetime DEFAULT NULL,
  `fAmount` decimal(16,10) DEFAULT NULL,
  `ffees` decimal(16,10) DEFAULT NULL,
  `fType` int(11) DEFAULT NULL COMMENT '1充值，',
  `fStatus` int(11) DEFAULT NULL,
  `flastUpdateTime` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `withdraw_virtual_address` varchar(128) DEFAULT NULL,
  `recharge_virtual_address` varchar(128) DEFAULT NULL,
  `ftradeUniqueNumber` varchar(180) DEFAULT NULL,
  `fconfirmations` int(11) DEFAULT '0',
  `fhasOwner` tinyint(1) DEFAULT NULL,
  `ishomeshow` tinyint(1) DEFAULT '1',
  `blockindex` int(11) DEFAULT NULL,
  `is_system_account` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`fId`),
  UNIQUE KEY `type_ftradeUniqueNumber` (`fType`,`ftradeUniqueNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='虚拟币资金流向';

-- ----------------------------
-- Table structure for fvirtualcoindesc
-- ----------------------------
DROP TABLE IF EXISTS `fvirtualcoindesc`;
CREATE TABLE `fvirtualcoindesc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` int(11) DEFAULT NULL,
  `coin_desc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fvirtualcointype
-- ----------------------------
DROP TABLE IF EXISTS `fvirtualcointype`;
CREATE TABLE `fvirtualcointype` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) DEFAULT NULL,
  `fName` varchar(32) DEFAULT NULL,
  `fShortName` varchar(32) DEFAULT NULL,
  `fDescription` varchar(128) DEFAULT NULL COMMENT '虚拟币描述|风险提示',
  `fAddTime` datetime DEFAULT NULL,
  `fstatus` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `fSymbol` varchar(3) DEFAULT NULL,
  `faccess_key` varchar(50) DEFAULT NULL,
  `fsecrt_key` varchar(50) DEFAULT NULL,
  `fip` varchar(50) DEFAULT NULL,
  `fport` varchar(10) DEFAULT NULL,
  `FIsShare` tinyint(1) DEFAULT NULL,
  `FIsWithDraw` tinyint(1) DEFAULT NULL,
  `furl` varchar(100) DEFAULT NULL,
  `fintroUrl` varchar(255) DEFAULT NULL,
  `fopenPrice` decimal(16,6) DEFAULT '0.000000',
  `ftotalAmount` decimal(16,6) DEFAULT '0.000000',
  `openTrade` varchar(20) DEFAULT '24-0',
  `equityType` tinyint(1) DEFAULT '0',
  `homeShow` tinyint(1) DEFAULT '0',
  `homeOrder` tinyint(10) DEFAULT '0',
  `typeOrder` tinyint(10) DEFAULT '0',
  `totalOrder` tinyint(10) unsigned DEFAULT '0' COMMENT '充提币排序',
  `isStarting` tinyint(1) DEFAULT '0' COMMENT '是否正在启用中',
  `confirm_times` int(11) DEFAULT '3' COMMENT '充值确认次数',
  `contract_address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`fId`),
  UNIQUE KEY `fvirtualcointype_fid` (`fId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='�����';

-- ----------------------------
-- Table structure for fvirtualoperationlog
-- ----------------------------
DROP TABLE IF EXISTS `fvirtualoperationlog`;
CREATE TABLE `fvirtualoperationlog` (
  `FId` int(11) NOT NULL AUTO_INCREMENT,
  `FQty` decimal(16,6) DEFAULT NULL,
  `FVirtualCoinTypeId` int(11) DEFAULT NULL,
  `FStatus` int(1) DEFAULT NULL,
  `FUserId` int(11) DEFAULT NULL,
  `FIsSendMsg` int(1) DEFAULT NULL,
  `FCreatorId` int(11) DEFAULT NULL,
  `FCreateTime` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`FId`),
  KEY `fk_voperationLog_VCoinTypeId` (`FVirtualCoinTypeId`),
  KEY `fk_voperationLog_UserId` (`FUserId`),
  KEY `fk_voperationLog_CreatorId` (`FCreatorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fvirtualwallet
-- ----------------------------
DROP TABLE IF EXISTS `fvirtualwallet`;
CREATE TABLE `fvirtualwallet` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `fVi_fId` int(11) DEFAULT NULL,
  `fTotal` decimal(16,8) DEFAULT '0.00000000',
  `fFrozen` decimal(16,8) DEFAULT '0.00000000' COMMENT '冻结资金',
  `fLastUpdateTime` datetime DEFAULT NULL,
  `fuid` int(15) DEFAULT NULL,
  `fBorrowBtc` decimal(16,6) DEFAULT NULL,
  `fCanlendBtc` decimal(16,6) DEFAULT NULL,
  `fFrozenLendBtc` decimal(16,6) DEFAULT NULL,
  `fAlreadyLendBtc` decimal(16,6) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `fHaveAppointBorrowBtc` decimal(16,6) DEFAULT NULL,
  `ishow` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`fId`),
  UNIQUE KEY `fvirtualwallet_fid` (`fId`),
  UNIQUE KEY `fuid_fvid_foreign` (`fuid`,`fVi_fId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='虚拟钱包';

-- ----------------------------
-- Table structure for fvitualcointraderank
-- ----------------------------
DROP TABLE IF EXISTS `fvitualcointraderank`;
CREATE TABLE `fvitualcointraderank` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `highest_bid` decimal(10,5) DEFAULT NULL,
  `lowest_ask` decimal(10,5) DEFAULT NULL,
  `last` decimal(10,5) DEFAULT NULL,
  `quoteVolume` decimal(20,6) DEFAULT NULL,
  `baseVolume` decimal(20,5) DEFAULT NULL COMMENT '成交额',
  `low24hr` decimal(10,5) DEFAULT NULL,
  `high24hr` decimal(10,5) DEFAULT NULL,
  `trade_time` int(20) DEFAULT NULL,
  `percent_change` decimal(10,5) DEFAULT NULL COMMENT '涨跌幅，该字段一般用不上，为了方便，现在数据库预留',
  `coin_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for privatechat_msg
-- ----------------------------
DROP TABLE IF EXISTS `privatechat_msg`;
CREATE TABLE `privatechat_msg` (
  `id` varchar(50) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `touser_id` int(11) DEFAULT NULL,
  `status` int(3) DEFAULT '1' COMMENT '1正常，2推送失败,3上线推送成功，4上线推送失败',
  `create_time` datetime DEFAULT NULL,
  `content` text,
  `type` int(11) DEFAULT '0',
  `msg_type` int(3) DEFAULT '1' COMMENT '1普通文本消息，2红包消息。后续有需求继续添加',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for publicblockaccount
-- ----------------------------
DROP TABLE IF EXISTS `publicblockaccount`;
CREATE TABLE `publicblockaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `total` decimal(16,8) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for redpacket
-- ----------------------------
DROP TABLE IF EXISTS `redpacket`;
CREATE TABLE `redpacket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parenid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `symbol` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1私聊红包，2群发红包',
  `category` int(1) DEFAULT NULL COMMENT '1发送，2领取',
  `status` int(1) DEFAULT NULL COMMENT '1等待领取，2已领取',
  `create_time` datetime DEFAULT NULL,
  `total` decimal(16,8) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enname` varchar(50) DEFAULT NULL COMMENT '角色名称英文名称',
  `chname` varchar(50) DEFAULT NULL COMMENT '角色中文名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统用户角色表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT '0',
  `password` varchar(50) COLLATE utf8_bin DEFAULT '0',
  `ip` varchar(50) COLLATE utf8_bin DEFAULT '0',
  `logintime` datetime DEFAULT '0000-00-00 00:00:00',
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `rolename` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `createuser` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统用户表';

-- ----------------------------
-- Table structure for sys_userrole
-- ----------------------------
DROP TABLE IF EXISTS `sys_userrole`;
CREATE TABLE `sys_userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sysuserid` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `sysroleid` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统用户角色表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fnick_name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `freal_name` varchar(20) DEFAULT NULL COMMENT '真实的姓名',
  `ftele_phone` varchar(20) DEFAULT NULL,
  `femail` varchar(30) DEFAULT NULL,
  `flogin_password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `ftrade_password` varchar(50) DEFAULT NULL COMMENT '支付密码',
  `flogin_name` varchar(20) DEFAULT NULL COMMENT '登录帐号，注册时的手机号，众股网的登录帐号',
  `fold_login_name` varchar(20) DEFAULT NULL COMMENT '原来的手机号码',
  `fidentity_no` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `fidentity_type` int(1) DEFAULT NULL,
  `fregister_time` datetime DEFAULT NULL COMMENT '注册时间',
  `flast_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `flast_update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `fhas_real_validate` tinyint(1) DEFAULT '0' COMMENT '是否实名信息',
  `fis_telephone_bind` tinyint(1) DEFAULT '0' COMMENT '是否绑定手机',
  `fis_mail_validate` tinyint(1) DEFAULT '0' COMMENT '是否验证邮箱',
  `fpost_real_validate` tinyint(1) DEFAULT '0' COMMENT '是否上传手持照片',
  `has_pay_pwd` tinyint(1) DEFAULT '0' COMMENT '是否设置交易密码',
  `fhas_real_validate_time` datetime DEFAULT NULL COMMENT '实名认证时间',
  `auth_status` int(1) DEFAULT '0' COMMENT '实名认证状态 3.未通过 2:已通过，1：已提交，0：未提交',
  `fidentity_status` int(1) DEFAULT '0' COMMENT '证件照审核状态 3.未通过 2:已通过，1：已提交，0：未提交',
  `fidentity_path` varchar(100) DEFAULT NULL COMMENT '身份证正面照片',
  `fidentity_path2` varchar(100) DEFAULT NULL COMMENT '身份证反面照片',
  `fidentity_path3` varchar(100) DEFAULT NULL COMMENT '手持证件照',
  `mem_words` varchar(100) DEFAULT NULL COMMENT '众股网openid',
  `fhead_img_url` varchar(100) DEFAULT NULL COMMENT '头像照片',
  `token` varchar(100) DEFAULT NULL,
  `gag_time` datetime DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for walletunlockinfo
-- ----------------------------
DROP TABLE IF EXISTS `walletunlockinfo`;
CREATE TABLE `walletunlockinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` int(11) DEFAULT NULL,
  `coin_name` varchar(100) DEFAULT NULL,
  `unlock_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for getAddress
-- ----------------------------
DROP PROCEDURE IF EXISTS `getAddress`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAddress`(IN `p_fviFid` int)
BEGIN

	set @addr := '';

	UPDATE fpool SET fstatus = 1, faddress = (SELECT @addr := faddress) WHERE fvi_type = p_fviFid AND fstatus = 0 limit 1;

	select @addr address;

END
;;
DELIMITER ;
