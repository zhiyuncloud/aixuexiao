--
-- 表的结构 `class`
--
CREATE TABLE IF NOT EXISTS `class` (
  `id` smallint(5) unsigned NOT NULL COMMENT '班级编号，302表示三年级二班',
  `name` char(16) NOT NULL COMMENT '班级名称，三年级二班',
  `headteacher` char(8) NOT NULL COMMENT '班主任姓名',
  `studentcount` tinyint(4) NOT NULL COMMENT '学生数量',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `class`
--
INSERT INTO `class` (`id`, `name`, `headteacher`, `studentcount`) VALUES
(302, '三年级二班', '赖导', 7),
(301, '三年级一班', '曾近荣', 7),

-- --------------------------------------------------------

--
-- 表的结构 `class_news`
--
CREATE TABLE IF NOT EXISTS `class_news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `classid` int(10) unsigned NOT NULL COMMENT '考试班级',
  `content` varchar(128) NOT NULL,
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_class_news` (`classid`,`inserttime`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;
--
-- 转存表中的数据 `class_news`
--

INSERT INTO `class_news` (`id`, `classid`, `content`, `inserttime`) VALUES
(1, 302, '大家好，三年级二班将于本周六举行家长会，届时请各位学生家长准时到达开会，谢谢！', '2013-08-21 10:42:04'),
(2, 301, '各位学生家长注意了，最近有不少同学出现逃学的情况，还号称“逃学威龙”。', '2013-08-21 10:48:20');

-- --------------------------------------------------------

--
-- 表的结构 `exam`
--

CREATE TABLE IF NOT EXISTS `exam` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '考试编号',
  `classid` int(10) unsigned NOT NULL COMMENT '考试班级',
  `course` char(8) NOT NULL COMMENT '科目',
  `examtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '考试时间',
  `fullmarks` decimal(4,1) NOT NULL COMMENT '满分',
  `average` decimal(4,1) DEFAULT NULL COMMENT '平均分',
  `topmark` decimal(4,1) DEFAULT NULL COMMENT '最高分',
  `lowestmark` decimal(4,1) DEFAULT NULL COMMENT '最低分',
  `remark` varchar(32) NOT NULL COMMENT '考试说明',
  PRIMARY KEY (`id`),
  KEY `index_exams` (`id`),
  KEY `index_classes` (`classid`,`course`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `exam`
--

INSERT INTO `exam` (`id`, `classid`, `course`, `examtime`, `fullmarks`, `average`, `topmark`, `lowestmark`, `remark`) VALUES
(1, 301, '英语', '2013-08-21 10:56:07', 100.0, 84.1, 100.0, 59.0, '精诚中学三年级二班下学期英语单元测验'),
(2, 302, '数学', '2013-08-22 11:02:20', 100.0, 88.3, 100.0, 78.0, '数学单元测验');

-- --------------------------------------------------------

--
-- 表的结构 `exam_mark`
--

CREATE TABLE IF NOT EXISTS `exam_mark` (
  `classid` int(10) unsigned NOT NULL COMMENT '考试班级',
  `studentid` int(10) unsigned NOT NULL COMMENT '学生编号',
  `studentname` char(8) NOT NULL COMMENT '学生姓名',
  `examid` int(10) unsigned NOT NULL COMMENT '考试编号',
  `mark` decimal(4,1) NOT NULL COMMENT '分数',
  `examtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '考试时间',
  `rank` tinyint(4) DEFAULT NULL COMMENT '班级排名',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`classid`,`studentid`,`examid`),
  KEY `index_exam_mark` (`classid`,`studentid`,`studentname`,`examid`,`mark`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `exam_mark`
--

INSERT INTO `exam_mark` (`classid`, `studentid`, `studentname`, `examid`, `mark`, `examtime`, `rank`, `remark`) VALUES
(301, 3011, '周星星', 1, 59.0, '2013-08-21 10:56:07', 7, '逃课就是这个下场'),
(301, 3013, '大飞', 1, 60.0, '2013-08-21 10:56:07', 6, '这次给你及格了'),
(301, 3014, '黄小龟', 1, 84.0, '2013-08-21 10:56:07', 5, '好好学习天天向上'),
(301, 3017, '林大岳', 1, 91.0, '2013-08-21 10:56:07', 4, '继续努力'),
(301, 3012, '曹达华', 1, 97.0, '2013-08-21 10:56:07', 3, '不错，有进步'),
(301, 3016, '汤朱迪', 1, 98.0, '2013-08-21 10:56:07', 2, '这次发挥有点小失常哟'),
(301, 3015, '仙蒂', 1, 100.0, '2013-08-21 10:56:07', 1, '满分不错，值得表扬'),
(302, 3027, '许博淳', 2, 78.0, '2013-08-22 11:02:20', 7, '要加油了'),
(302, 3022, '柯景腾', 2, 80.0, '2013-08-22 11:02:20', 6, '上课认真听讲'),
(302, 3024, '谢明和', 2, 87.0, '2013-08-22 11:02:20', 5, '好好学习天天向上'),
(302, 3026, '胡家玮', 2, 88.0, '2013-08-22 11:02:20', 4, '继续努力'),
(302, 3023, '曹国胜', 2, 90.0, '2013-08-22 11:02:20', 3, '有进步'),
(302, 3025, '廖英宏', 2, 95.0, '2013-08-22 11:02:20', 2, '非常好'),
(302, 3021, '沈佳宜', 2, 100.0, '2013-08-22 11:02:20', 1, '非常不错，好好保持');

-- --------------------------------------------------------

--
-- 表的结构 `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tousername` char(32) NOT NULL,
  `fromusername` char(32) NOT NULL,
  `msgtype` enum('TEXT','IMAGE','LOCATION','LINK','EVENT') NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `msgId` char(64) NOT NULL,
  `content` varchar(128) DEFAULT NULL,
  `picurl` varchar(128) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `locationx` char(10) DEFAULT NULL,
  `locationy` char(10) DEFAULT NULL,
  `scale` char(8) DEFAULT NULL,
  `label` varchar(32) DEFAULT NULL,
  `event` varchar(16) DEFAULT NULL,
  `eventkey` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_user` (`msgtype`,`tousername`,`fromusername`,`createtime`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


-- --------------------------------------------------------

--
-- 表的结构 `reply`
--

CREATE TABLE IF NOT EXISTS `reply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tousername` char(32) NOT NULL,
  `fromusername` char(32) NOT NULL,
  `msgtype` enum('TEXT','MUSIC','NEWS') NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` varchar(512) NOT NULL COMMENT '回复消息内容',
  `musicurl` varchar(128) DEFAULT NULL,
  `hqmusicurl` varchar(128) DEFAULT NULL,
  `articlecount` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_user` (`msgtype`,`tousername`,`fromusername`,`createtime`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 表的结构 `reply_article`
--
CREATE TABLE IF NOT EXISTS `reply_article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `replyid` int(10) unsigned NOT NULL,
  `title` varchar(32) NOT NULL,
  `description` varchar(64) NOT NULL,
  `picurl` varchar(128) NOT NULL,
  `url` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index_replyid` (`replyid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;



--
-- 表的结构 `student`
--
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(10) unsigned NOT NULL COMMENT '学生学号，通常为班级编号加上序号，如3021',
  `classid` int(10) unsigned NOT NULL COMMENT '所属班级编号',
  `name` char(8) NOT NULL COMMENT '学生姓名',
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_classes` (`classid`,`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `student`
--
INSERT INTO `student` (`id`, `classid`, `name`, `remark`) VALUES
(3021, 302, '沈佳宜', '佳宜（女主角）'),
(3022, 302, '柯景腾', '柯腾（男主角）'),
(3023, 302, '曹国胜', '老曹(柯腾的挚友)'),
(3024, 302, '谢明和', '阿和(柯腾的挚友)'),
(3025, 302, '廖英宏', '该边(柯腾的挚友)'),
(3026, 302, '胡家玮', '弯弯(沈佳宜的好友)'),
(3027, 302, '许博淳', '勃起(柯腾的挚友)'),
(3011, 301, '周星星', '周星驰'),
(3012, 301, '曹达华', '吴孟达'),
(3013, 301, '大飞', '张耀扬'),
(3014, 301, '黄小龟', '黄一山'),
(3015, 301, '仙蒂', '朱茵'),
(3016, 301, '汤朱迪', '梅艳芳'),
(3017, 301, '林大岳', '黄秋生');

-- --------------------------------------------------------

--
-- 表的结构 `student_message`
--
CREATE TABLE IF NOT EXISTS `student_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `studentid` int(10) unsigned NOT NULL COMMENT '学生编号',
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index_student_message` (`studentid`,`inserttime`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `student_message`
--

INSERT INTO `student_message` (`id`, `studentid`, `inserttime`, `content`) VALUES
(1, 3011, '2013-08-21 11:09:44', '不准逃课'),
(2, 3021, '2013-08-22 10:56:15', '好好学习天天向上哈');
