/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50627
 Source Host           : localhost
 Source Database       : book

 Target Server Type    : MySQL
 Target Server Version : 50627
 File Encoding         : utf-8

 Date: 01/01/2020 09:48:40 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` char(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `book`
-- ----------------------------
BEGIN;
INSERT INTO `book` VALUES ('1', '杨绛', '这是一本小说，不错。推荐你阅读', '我们仨', '1'), ('2', '刘慈欣', '一本科幻小说', '时间移民', '2'), ('4', '简·麦戈尼格尔 ', '游戏是我们集中精力的大好机会，我们乐观向上地做着一件自己擅长并享受的事情', '游戏改变世界', '0'), ('5', '彼得·蒂尔 / 布莱克·马斯特斯 ', '帮助你思考从0到1的秘密，在意想不到之处发现价值与机会', '从0到1', '2'), ('6', '[美] 德内拉·梅多斯 ', '是一本简明扼要的系统思考入门指南，也是认识复杂动态系统的有力工具', '系统之美', '1'), ('7', '彼得•迈尔斯 (Peter Meyers) / 尚恩•尼克', '通过演讲一举赢得支持实现梦想', '高效演讲', '0'), ('8', '凯文·凯利', '经济和社会发展的趋势有着深刻的见解', '必然', '2'), ('9', '凯文·凯利', '这可能是90年代最重要的一本书', '失控', '1'), ('10', '李笑来', '时间管理不了，只能管理自己', '把时间当作朋友', '2'), ('11', '李笑来', '七年就是一辈子', '七年就是一辈子', '1'), ('12', '王东岳', '一本哲理随笔，汇集了作者数十年的思想精髓。哲学', '知鱼之乐', '0'), ('13', '王东岳', '一本哲学书', '物演通论', '0'), ('14', '查理·芒格', '收录了查理•芒格的个人传记与投资哲学', '穷查理宝典', '1'), ('15', 'Andy Hunt ', '思考如何解决问题', '程序员思维修炼', '2'), ('16', 'Andy Hunt ', '学有所思，思有所悟，悟有所行', '高效程序员的45个习惯', '1'), ('17', '格雷厄姆', '主要介绍黑客即优秀程序员的爱好和动机', '黑客与画家', '0'), ('18', '安德斯•艾利克森', '如何学习一项技能的方法', '刻意练习', '2'), ('19', '李善友', '关于创业的方法论', '创业方法论', '1'), ('20', '李笑来', '这是一本不错的书', '和时间做朋友', '0'), ('21', '张三', '我随便写的一个书', '私生活', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
