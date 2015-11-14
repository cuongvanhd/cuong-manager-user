/*
Navicat MySQL Data Transfer

Source Server         : vancuong
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : dbmanageuser_nguyenvancuong

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-15 01:12:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `mst_group`
-- ----------------------------
DROP TABLE IF EXISTS `mst_group`;
CREATE TABLE `mst_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mst_group
-- ----------------------------
INSERT INTO mst_group VALUES ('1', 'Phòng phát triển số 1');
INSERT INTO mst_group VALUES ('2', 'Phòng phát triển số 2');
INSERT INTO mst_group VALUES ('3', 'Phòng phát triển số 3');
INSERT INTO mst_group VALUES ('4', 'Phòng phát triển số 4');

-- ----------------------------
-- Table structure for `mst_japan`
-- ----------------------------
DROP TABLE IF EXISTS `mst_japan`;
CREATE TABLE `mst_japan` (
  `code_level` varchar(15) NOT NULL,
  `name_level` varchar(255) NOT NULL,
  PRIMARY KEY (`code_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mst_japan
-- ----------------------------
INSERT INTO mst_japan VALUES ('N1', 'Trình độ tiếng nhật cấp 1');
INSERT INTO mst_japan VALUES ('N2', 'Trình độ tiếng nhật cấp 2');
INSERT INTO mst_japan VALUES ('N3', 'Trình độ tiếng nhật cấp 3');
INSERT INTO mst_japan VALUES ('N4', 'Trình độ tiếng nhật cấp 4');
INSERT INTO mst_japan VALUES ('N5', 'Trình độ tiếng nhật cấp 5');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_detail_user_japan`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_detail_user_japan`;
CREATE TABLE `tbl_detail_user_japan` (
  `detail_user_japan_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `code_level` varchar(15) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`detail_user_japan_id`),
  KEY `fk_tbl_user` (`user_id`),
  KEY `fk_mst_japan` (`code_level`),
  CONSTRAINT `fk_mst_japan` FOREIGN KEY (`code_level`) REFERENCES `mst_japan` (`code_level`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_detail_user_japan
-- ----------------------------
INSERT INTO tbl_detail_user_japan VALUES ('70', '1', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('71', '2', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('72', '3', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('73', '4', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('74', '5', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('75', '6', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('77', '8', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('78', '9', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('79', '10', 'N2', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('80', '11', 'N2', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('81', '12', 'N2', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('82', '13', 'N2', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('83', '14', 'N2', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('84', '15', 'N2', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('85', '16', 'N3', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('86', '17', 'N3', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('87', '18', 'N3', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('88', '19', 'N3', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('89', '20', 'N3', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('90', '21', 'N3', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('91', '22', 'N4', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('92', '23', 'N4', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('93', '24', 'N4', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('94', '15', 'N4', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('95', '26', 'N4', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('96', '27', 'N4', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('97', '28', 'N5', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('98', '29', 'N5', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('99', '30', 'N5', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('100', '31', 'N5', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('101', '32', 'N5', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('102', '33', 'N5', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('103', '34', 'N5', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('104', '35', 'N1', '2014-11-11', '2015-11-11', '290');
INSERT INTO tbl_detail_user_japan VALUES ('105', '48', 'N4', '2015-01-01', '2016-01-01', '333');
INSERT INTO tbl_detail_user_japan VALUES ('106', '49', 'N5', '2015-01-05', '2016-01-05', '333');
INSERT INTO tbl_detail_user_japan VALUES ('108', '53', 'N5', '2015-01-11', '2016-01-11', '222');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `login_name` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `full_name_kata` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_mst_group` (`group_id`),
  CONSTRAINT `fk_mst_group` FOREIGN KEY (`group_id`) REFERENCES `mst_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO tbl_user VALUES ('1', '1', 'admin', 'admin', 'Bùi Đức An', 'ビ ク アン', 'ad@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('2', '1', 'anhlt', 'anhlt', 'Lâm Thị Anh', 'ム ス アイン', 'anhlt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('3', '1', 'anhnt', 'anhnt', 'Nguyễn Tuấn Anh', 'ングイン トゥン アイン', 'anhnt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('4', '1', 'anhtt', 'anhtt', 'Trần Tuấn Anh', 'トルン トゥン アイン', 'anhtt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('5', '1', 'binhtt', 'binhtt', 'Trần Thái Bình', 'トルン シ ブン', 'binhtt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('6', '1', 'congnt', 'congnt', 'Nguyễn Tiến Công', 'ングイン ティン クング', 'congnt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('8', '2', 'cuongnd', '123456', 'Nguyễn Đức Cường', 'ングイン ク クング ', 'cuongnd@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('9', '2', 'cuongnv', '123456', 'Nguyễn Văn Cường', 'ングイン ブン クング', 'cuongnv@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('10', '2', 'cuongtv', '123456', 'Trần Văn Cường', 'トルン ブン クング', 'cuongtv@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('11', '2', 'dungdn', '123456', 'Đỗ Ngọc Dũng', 'ド ングク ドング', 'đungn@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('12', '2', 'dungdn', '123456', 'Đỗ Ngọc Dũng', 'ド ングク ドング', 'đungn@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('13', '3', 'dunght', '123456', 'Hà Tuấn Dũng', 'ホ トゥン ドング', 'dunght@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('14', '3', 'dungnt', '123456', 'Nguyễn Tất Dũng', 'ングイン ット ドング', 'dungnt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('15', '3', 'dungvt', '123456', 'Vũ Việt Dũng', 'ブ ビット ドング', 'dungvt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('16', '3', 'duonglb', '123456', 'Lý Bình DƯơng', 'ル ブン ドング', 'duonglb@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('17', '3', 'duongns', '123456', 'Nguyễn Sơn Dương', 'ングイン スン ドング', 'duongns@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('18', '3', 'datnd', '123456', 'Nguyễn Đăng Đạt', 'ングイン ング ット', 'datnd@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('19', '4', 'ducnh', '123456', 'Nguyễn Như Đức', 'ングイン ン ク', 'ducnh@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('20', '4', 'ductt', '123456', 'Trần Trọng Đức', 'トルン トルング ク ', 'ductt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('21', '4', 'giangmx', '123456', 'Mai Xuân Giang', 'メー ズン ジアング', 'giangmx@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('22', '4', 'gonvv', '123456', 'Vũ Văn Gôn', 'ブ ブン グン', 'gonvv@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('23', '4', 'hapt', '123456', 'Phan Thanh Hà', 'ファン セーン ホ', 'hapt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('24', '4', 'hainm', '123456', 'Ngô Mạnh Hải', 'ング ムン ヒ', 'hainm@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('25', '3', 'hainv', '123456', 'Nguyễn Văn Hải', 'ングイン ブン ヒ', 'hainv@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('26', '3', 'hientt', '123456', 'Trần Thị Hiền', 'トルン ス ヒン', 'hientt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('27', '4', 'hieudt', '123456', 'Đào Trung Hiếu', 'オ トルング フー', 'hieudt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('28', '4', 'hoanx', '123456', 'Ngô Xuân Hòa', 'ング ズン ハ', 'hoanx@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('29', '1', 'huync', '123456', 'Nguyễn Công Huy', 'ングイン クング フイ', 'huync@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('30', '2', 'huyenct', '123456', 'Cao Thị Huyền', 'カオ ス フイン', 'huyenct@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('31', '1', 'huynhtd', '123456', 'Trần Đình Huynh', 'トルン ン フイン', 'huynhtd@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('32', '1', 'hungdv', '123456', 'Đỗ Văn Hùng', 'トルン ン フイン', 'hungdv@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('33', '2', 'hungnv', '123456', 'Nguyễn Văn Hùng', 'ングイン ブン フング', 'hungnv@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('34', '2', 'hungnv', '123456', 'Nguyễn Việt Hùng', 'ングイン ビット フング', 'hungnv@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('35', '3', 'huongct', '123456', 'Cao Thu Hương', 'カオ ス フング', 'huongct@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('36', '3', 'khanhmd', '123456', 'Mai Duy Khánh', 'メー ドゥイ クニ', 'khanhmd@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('37', '3', 'kienqt', '123456', 'Quản Trung Kiên', 'クン トルング キン', 'kienqt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('38', '4', 'lamnn', '123456', 'Nguyễn Ngọc Lâm', 'ングイン ングク ム', 'lamnn@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('39', '4', 'lieuvt', '123456', 'Vũ Thị Liễu', 'ブ ス ルー', 'lieuvt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('40', '2', 'linhnn', '123456', 'Nguyễn Ngọc Linh', 'ングイン ングク リン', 'linhnn@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('41', '2', 'linhvc', '123456', 'Vũ Chí Linh', 'ブ チョ リン', 'linhvc@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('42', '1', 'locnx', '123456', 'Nguyễn Xuân Lộc', 'ングイン ズン ルク', 'locnx@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('43', '3', 'luunt', '123456', 'Nguyễn Tiến Lưu', 'ングイン ティン ル', 'luunt@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('44', '1', 'dungdn', '123456', '//', '//', '//@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('46', '2', 'test', '123456', '\\\\', '\\\\', 'test@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('47', '2', 'test1', '123456', 'John\'s Lee', 'ジョンス リー ', 'test1@luvina.net', '0123456789', '1992-12-12');
INSERT INTO tbl_user VALUES ('48', '2', 'test3', '5f4dcc3b5aa765d61d8327deb882cf99', '%test3', '', 'test3@luvina.net', '012-34-56', '1992-12-12');
INSERT INTO tbl_user VALUES ('49', '1', 'ssssss', '12345', 'cuong', 'クオンヴァカ', 'a1111111d@luvina.net', '111-111-1111', '1999-05-13');
INSERT INTO tbl_user VALUES ('50', '1', 'ssssss111', '5f4dcc3b5aa765d61d8327deb882cf99', 'cuong111', 'クオンヴァカ', 'a11d@luvina.net', '111-111-1111', '1999-01-13');
INSERT INTO tbl_user VALUES ('52', '2', 'pfpfpfpfpfpfpf1', '5f4dcc3b5aa765d61d8327deb882cf99', 'pfpfpfpfpfpfpf1', 'チチチチチチチッチ', 'fefefefef@hrhrgr.vofg', '111-111-111', '2010-02-25');
INSERT INTO tbl_user VALUES ('53', '3', 'pfpfpfpfpfpfpf2', '5f4dcc3b5aa765d61d8327deb882cf99', 'pfpfpfpfpfpfpf122', 'チチチチチチチッチ', 'fefefefe3f@hrhrgr.vofg', '111-111-111', '2008-04-28');
