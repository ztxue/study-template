package com.example.blog.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@SuppressWarnings("all")
public class StringUtils {
    /**
     * @return boolean
     * @description: : 判断 字符串中是否包含空格,为空,为'null'
     */
    public static boolean isTrim(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str);
    }

    /**
     * 过滤特殊字符
     */
    public static String stringFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx = "[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    /**
     * 将集合转换成字符串
     */
    public static String listToString(List<String> list) {
        StringBuilder keywodString = new StringBuilder();
        for (String key : list) {
            keywodString.append(key).append(",");
        }
        return keywodString.toString();

    }

    /**
     * 获得字符串中的中文部分
     */
    public static String getChineseString(String paramValue) {
        String regex = "([\u4e00-\u9fa5]+)";
        StringBuilder str = new StringBuilder();
        Matcher matcher = Pattern.compile(regex).matcher(paramValue);
        while (matcher.find()) {
            str.append(matcher.group(0));
        }
        return str.toString();
    }


    /**
     * 将阿拉伯数字转换成中文数字
     */
    public static String numToChinese(String number) {
        String[] s1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] s2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        StringBuilder result = new StringBuilder();
        int n = number.length();
        for (int i = 0; i < n; i++) {
            int num = number.charAt(i) - '0';
            if (i != n - 1 && num != 0) {
                if (n > 2 || num != 1) {
                    result.append(s1[num]).append(s2[n - 2 - i]);
                } else {
                    result.append(s2[n - 2 - i]);
                }
            } else {
                result.append(s1[num]);
            }
        }
        //如果结尾有零
        if (result.length() > 1) {
            if (result.lastIndexOf("零") == result.length() - 1) {
                result = new StringBuilder(result.substring(0, result.length() - 1));
            }
        } else {
            return result.toString();
        }
        return result.toString();
    }

    /**
     * 获得正则表达式匹配到的字符串
     *
     * @param str      正则表达式
     * @param question 字符串
     * @return 匹配到的字符串
     */
    public static String getStringValue(String str, String question) {
        String resault = "";
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(question);
        if (matcher.find()) {
            resault += matcher.group(1);
        }
        return resault;
    }

    /**
     * 获得字符串中所有的数字字符串
     */
    public static List<String> getNumberStirng(String stringVale) {
        List<String> list = null;
        if (!isEmpty(stringVale)) {
            String regEx = "[0-9]+";
            Pattern pat = Pattern.compile(regEx);
            Matcher mat = pat.matcher(stringVale);
            list = new ArrayList<>();
            while (mat.find()) {
                list.add(mat.group());
            }
        }
        return list;
    }

    /**
     * 使用正则表达式删除匹配到的数据
     *
     * @param str      正则表达式
     * @param question 待处理字符串
     */
    public static String deleteStringValue(String str, String question) {
        String result = question;
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(question);
        if (matcher.find()) {
            result = matcher.replaceAll("");
        }
        return result;
    }

    /**
     * 根据正则表达式判断
     *
     * @param str         规则正则表达式
     * @param stringValue 待判断字符串
     */
    public static boolean checkRegular(String str, String stringValue) {

        if (isEmpty(str) || isEmpty(stringValue)) {
            return false;
        }
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(stringValue);
        return matcher.find();

    }

    /**
     * @description: 截取特定开头特定结尾的字符串并去掉头和尾
     */
    public static String subStringSpecial(String sta, String end, String data) {
        Matcher m1 = Pattern.compile(sta + ".*?" + end,
                Pattern.CASE_INSENSITIVE).matcher(data);
        String nString = null;
        while (m1.find()) {
            nString = m1.group();
            if (nString != null && nString.length() > 0) {
                if (!isEmpty(sta)) {
                    Matcher m_ = Pattern.compile(sta,
                            Pattern.CASE_INSENSITIVE).matcher(nString);
                    if (m_.find()) {//掐头
                        nString = m_.replaceAll("");
                    }
                }
                if (!isEmpty(end) && !end.equals("$")) {
                    Matcher m__ = Pattern.compile(end,
                            Pattern.CASE_INSENSITIVE).matcher(nString);
                    if (m__.find()) {//去尾
                        nString = m__.replaceAll("");
                    }
                }
            }
        }
        return nString;
    }

    /**
     * @description: 截取特定开头特定结尾的字符串
     */
    public static String subStringSpecialNotDel(String sta, String end, String data) {
        Matcher m1 = Pattern.compile(sta + ".*?" + end,
                Pattern.CASE_INSENSITIVE).matcher(data);
        String nString = null;
        while (m1.find()) {
            nString = m1.group();
        }
        return nString;
    }

    /**
     * @description: 截取特定开头特定结尾的字符串组
     */
    public static List<String> subStringsSpecial(String sta, String end, String data) {
        List<String> returnList = new ArrayList<String>();
        Matcher m1 = Pattern.compile(sta + ".*?" + end,
                Pattern.CASE_INSENSITIVE).matcher(data);
        String nString = null;
        while (m1.find()) {
            nString = m1.group();
            if (nString != null && nString.length() > 0) {
                returnList.add(nString);
            }
        }
        return returnList;
    }

    /**
     * 获得字符串中符合条件的数据个数
     *
     * @param str  正则表达式
     * @param data 字符串数据
     */
    public static Integer getSize(String str, String data) {
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(data);
        List<String> list = new ArrayList<>();
        int number = 0;
        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                list.add(matcher.group(0));
            }
            number++;
        }
        return number;
    }

    /**
     * 获得字符串中所有被匹配到的数据
     *
     * @param str  正则表达式
     * @param data 匹配的字符串数据
     */
    public static List<String> getArray(String str, String data) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                list.add(matcher.group(0));
            }
        }
        return list;
    }

    /**
     * 将中文数字转换成阿拉伯数字
     *
     * @param chineseNumber 中文数字
     */
    public static int getNum(String chineseNumber) {
        int result = 0;
        int temp = 1;//存放一个单位的数字如：十万
        int count = 0;//判断是否有chArr
        char[] cnArr = new char[]{'一', '二', '三', '四', '五', '六', '七', '八', '九'};
        char[] chArr = new char[]{'十', '百', '千', '万', '亿'};
        for (int i = 0; i < chineseNumber.length(); i++) {
            boolean b = true;//判断是否是chArr
            char c = chineseNumber.charAt(i);
            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                if (c == cnArr[j]) {
                    if (0 != count) {//添加下一个单位之前，先把上一个单位值添加到结果中
                        result += temp;
                        temp = 1;
                        count = 0;
                    }
                    // 下标+1，就是对应的值
                    temp = j + 1;
                    b = false;
                    break;
                }
            }
            if (b) {//单位{'十','百','千','万','亿'}
                for (int j = 0; j < chArr.length; j++) {
                    if (c == chArr[j]) {
                        switch (j) {
                            case 0:
                                temp *= 10;
                                break;
                            case 1:
                                temp *= 100;
                                break;
                            case 2:
                                temp *= 1000;
                                break;
                            case 3:
                                temp *= 10000;
                                break;
                            case 4:
                                temp *= 100000000;
                                break;
                            default:
                                break;
                        }
                        count++;
                    }
                }
            }
            if (i == chineseNumber.length() - 1) {//遍历到最后一个字符
                result += temp;
            }
        }
        return result;
    }

    /**
     * 将数组转换成集合
     */
    public static List<String> arrayToList(String[] strings) {
        if (strings == null || strings.length <= 0) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        return list;
    }

    /**
     * 字符串转ASCII
     */
    public static String stringToAscii(String value) {
        StringBuilder sbu = new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * @description: 中文转Unicode
     */
    public static String hanToUnicode(String gbString) {   //gbString = "测试"
        char[] utfBytes = gbString.toCharArray();   //utfBytes = [测, 试]
        StringBuilder unicodeBytes = new StringBuilder();
        for (char utfByte : utfBytes) {
            String hexB = Integer.toHexString(utfByte);   //转换为16进制整型字符串
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes.append("\\u").append(hexB);
        }
        return unicodeBytes.toString();
    }

    /**
     * @description: 不带单位的纯中文数字换成阿拉伯数字
     */
    public static String getNumber(String chineseNumber) {
        chineseNumber = chineseNumber.replaceAll("零", "0");
        chineseNumber = chineseNumber.replaceAll("幺", "1");
        chineseNumber = chineseNumber.replaceAll("一", "1");
        chineseNumber = chineseNumber.replaceAll("二", "2");
        chineseNumber = chineseNumber.replaceAll("三", "3");
        chineseNumber = chineseNumber.replaceAll("四", "4");
        chineseNumber = chineseNumber.replaceAll("五", "5");
        chineseNumber = chineseNumber.replaceAll("六", "6");
        chineseNumber = chineseNumber.replaceAll("七", "7");
        chineseNumber = chineseNumber.replaceAll("八", "8");
        chineseNumber = chineseNumber.replaceAll("九", "9");
        return chineseNumber;
    }

    /**
     * 解码 Unicode \\uXXXX
     */
    private static final Pattern P = Pattern.compile("\\\\u([0-9a-fA-F]{4})");

    public static String decodeUnicode(String str) {
        Charset set = StandardCharsets.UTF_16;
        Matcher m = P.matcher(str);
        int start = 0;
        int start2 = 0;
        StringBuilder sb = new StringBuilder();
        while (m.find(start)) {
            start2 = m.start();
            if (start2 > start) {
                String seg = str.substring(start, start2);
                sb.append(seg);
            }
            String code = m.group(1);
            int i = Integer.valueOf(code, 16);
            byte[] bb = new byte[4];
            bb[0] = (byte) ((i >> 8) & 0xFF);
            bb[1] = (byte) (i & 0xFF);
            ByteBuffer b = ByteBuffer.wrap(bb);
            sb.append(String.valueOf(set.decode(b)).trim());
            start = m.end();
        }
        start2 = str.length();
        if (start2 > start) {
            String seg = str.substring(start, start2);
            sb.append(seg);
        }
        return sb.toString();
    }

    /**
     * 将下划线分隔的字符串转换驼峰命名格式
     *
     * @param underlineStr 下划线分隔的字符串
     * @return java.lang.String
     * @author zhaotao
     * @date 2018/09/04 17:05
     */
    public static String underlineToCamelCase(String underlineStr) {
        String[] words = underlineStr.split("_");

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);

        for (int i = 1; i < words.length; i++) {
            sb.append(words[i].substring(0, 1).toUpperCase())
                    .append(words[i].substring(1));
        }

        return sb.toString();
    }

    /**
     * 判断数组中是否存在给定字符串
     *
     * @param stringObject 给定字符串
     * @param stringArrays 字符串数组
     */
    public static boolean ifExistStringValueInArray(String stringObject, String[] stringArrays) {
        boolean bean = false;
        if (isEmpty(stringObject) || stringArrays == null || stringArrays.length <= 0) {
            return false;
        }
        for (String obj : stringArrays) {
            if (isEmpty(obj)) {
                continue;
            }
            if (obj.equals(stringObject)) {
                bean = true;
                break;
            }
        }
        return bean;
    }

    /**
     * 判断是否为空
     */
    public static boolean isBlank(String str) {
        return org.apache.commons.lang3.StringUtils.isBlank(str);
    }

    /**
     * 提取字符串中的数字
     */
    public static Integer getStringNum(String strInput) {
        //匹配指定范围内的数字
        String regEx = "[^0-9]";
        //Pattern是一个正则表达式经编译后的表现模式
        Pattern p = Pattern.compile(regEx);
        // 一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。
        Matcher m = p.matcher(strInput);
        //将输入的字符串中非数字部分用空格取代并存入一个字符串
        String string = m.replaceAll(" ").trim();
        //以空格为分割符在讲数字存入一个字符串数组中
        String[] strArr = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        //遍历数组转换数据类型输出
        for (String s : strArr) {
            stringBuilder.append(s);
            System.out.println(Integer.parseInt(s));
        }
        String num = stringBuilder.toString();
        System.out.println("提取数字结果-> " + num);
        return Integer.valueOf(num);
    }

    /**
     * 根据完整url得到struts.config中的path
     *
     * @param url    完整url如localhost:8080/xxx/xxx.do
     * @param levnum path有几个'/'(项目分模块时用到)
     * @return xxx.do
     */
    public static String getPathByUrl(String url, int levnum) {
        int doindex = url.lastIndexOf("/");

        while (levnum > 1) {
            doindex = url.lastIndexOf("/", doindex - 1);
            levnum--;
        }
        return url.substring(doindex);
    }

    /**
     * 产生length位随机码(数字)
     *
     * @param length 随机码长度
     * @return 生成的数字(字符串形式 ， 可以0打头)
     */
    public static String getRandomCode(int length) {
        int num = new Double(Math.random() * Math.pow(10, length)).intValue();
        return org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(num), length, "0");
    }

    /**
     * 产生length位随机码(0~9 a~z)
     *
     * @param length 随机码长度
     * @return 生成的随机码
     */
    public static String getRandomPwCode(int length) {
        StringBuilder sRand = new StringBuilder();
        Random random = new Random();
        char[] randchar = new char[]{'1', '2', '3', '4', '5', '6', '7', '8',
                '9', '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        char temp;
        for (int i = 0; i < length; i++) {
            temp = randchar[random.nextInt(randchar.length)];
            sRand.append(temp);
        }
        return sRand.toString();
    }

    /**
     * 抽奖
     *
     * @param rate 中奖率
     * @return 是否中奖
     */
    public static boolean checkRandomPrise(double rate) {
        return Math.random() < rate;
    }


    /**
     * 判断对象obj是否有和objs中的对象相同
     *
     * @param objs objs
     * @param obj  obj
     * @return result
     */
    public static boolean isContains(Object[] objs, Object obj) {
        if (null == objs) {
            return false;
        }
        for (Object o : objs) {
            if ((null == o && null == obj)
                    || (null != o && o.equals(obj))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断对象是否为空，或者空字符串
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj || "null".equals(obj)) {
            return true;
        } else if (obj instanceof String) {
            return org.apache.commons.lang3.StringUtils.isEmpty(obj.toString());
        }
        return false;
    }

    /**
     * 从一个对象里获取一个字符串
     */
    public static String getStringFromObject(Object obj) {
        if (!isEmpty(obj)) {
            if (obj instanceof String) {
                return obj.toString();
            } else if (obj instanceof Object[]) {
                return ((Object[]) obj)[0].toString();
            }
        }
        return null;
    }
    /**
     * 作者: gcl
     * 说明: 生成UUID唯一码
     */
    public static String getUuid() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
