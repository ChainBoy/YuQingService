package com.vrv.nj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsUtil
{
    
    /**
     * 将str两边加上圆括号(),如"abc"加上括号后"(abc)"，如果两边已经有圆括号，则不加
     * 
     * @param str
     * @return
     */
    private static int counter = 0;
    
    public static String addBrackets(String str)
    {
        if (isNullStr(str) || str.matches("\\(.*\\)"))
        {
            return str;
        }
        else if (str.startsWith(" NOT "))
        {
            return str;
        }
        return "(" + str + ")";
    }
    
    private static Pattern PARSENOTANDSPACE = Pattern.compile("[^\\-\\s]+");
    
    /**
     * 对关键词中包含-号空格进行处理
     * 
     * @param keyword
     * @return
     */
    private static String parseNotAndSpace(String keyword)
    {
        counter = 0;
        int num = countStr(keyword, "-");
        String str1 = null;
        String str2 = null;
        String phrase = null;
        if (num >= 2)
        {
            String str = keyword;
            str1 = str.substring(0, keyword.indexOf("-") + 1);
            Matcher m = PARSENOTANDSPACE.matcher(str1);
            StringBuffer kw = new StringBuffer();
            while (m.find())
            {
                String mGroup = m.group();
                if (isNullStr(mGroup))
                {
                    continue;
                }
                mGroup = Matcher.quoteReplacement(mGroup);
                m.appendReplacement(kw, "\\\\\"" + mGroup.trim() + "\\\\\"");
            }
            m.appendTail(kw);
            str1 = kw.toString();
            
            str = keyword;
            str2 = keyword.substring(keyword.indexOf("-") + 1);
            Matcher m2 = PARSENOTANDSPACE.matcher(str2);
            StringBuffer kw2 = new StringBuffer();
            while (m2.find())
            {
                String mGroup2 = m2.group();
                if (isNullStr(mGroup2))
                {
                    continue;
                }
                mGroup2 = Matcher.quoteReplacement(mGroup2);
                m2.appendReplacement(kw2, "\\\\\"" + mGroup2.trim() + "\\\\\"");
            }
            m2.appendTail(kw2);
            str2 = kw2.toString();
            str2 = str2.replace("-", ",");
            phrase = str1 + "(" + str2 + ")";
        }
        else
        {
            Matcher m = PARSENOTANDSPACE.matcher(keyword);
            StringBuffer kw = new StringBuffer();
            while (m.find())
            {
                String mGroup = m.group();
                if (isNullStr(mGroup))
                {
                    continue;
                }
                mGroup = Matcher.quoteReplacement(mGroup);
                m.appendReplacement(kw, "\\\\\"" + mGroup.trim() + "\\\\\"");
            }
            m.appendTail(kw);
            phrase = kw.toString();
        }
        
        while (phrase.endsWith("-") || phrase.endsWith(" "))
        { // delete character "|" "+" end of phrase
            phrase = phrase.substring(0, phrase.length() - 1);
        }
        /*
         * while(phrase.startsWith("-")||phrase.startsWith(" ")){ //delete character "|" "+" begin at phrase
         * phrase=phrase.substring(1);
         * // phrase = " NOT "+phrase;
         * }
         */
        return phrase.replaceAll("\\s+", " AND ").replaceAll("\\-+", " NOT ");
    }
    
    private static Pattern PARSEFIELDTOPHRASE = Pattern.compile("[^()+,]+");
    
    /**
     * 处理搜索规则，满足搜索引擎规范
     * 
     * @param keyword
     * @return
     */
    public static String parseESTerm(String keyword)
    {
        // keyword = keyword.replaceAll("-"," NOT ");
        Matcher m = PARSEFIELDTOPHRASE.matcher(keyword);
        StringBuffer kw = new StringBuffer();
        String[] kws = null;
        while (m.find())
        {
            String mGroup = m.group();
            if (isNullStr(mGroup))
            {
                continue;
            }
            mGroup = Matcher.quoteReplacement(mGroup);
            kws = mGroup.trim().split("[\\s\\-]+");
            if (kws.length > 1)
            {
                m.appendReplacement(kw, addBrackets(parseNotAndSpace(mGroup.trim())));
            }
            else
            {
                m.appendReplacement(kw, "\\\"" + mGroup.trim() + "\\\"");
            }
        }
        m.appendTail(kw);
        String phrase = kw.toString();
        while (phrase.endsWith(",") || phrase.endsWith("+"))
        {// delete character "|" "+" end of phrase
         // System.out.println("1>>"+phrase);
            phrase = phrase.substring(0, phrase.length() - 1);
        }
        while (phrase.startsWith(",") || phrase.startsWith("+"))
        {// delete character "|" "+" begin at phrase
         // System.out.println("2>>"+phrase);
            phrase = phrase.substring(1);
        }
        // System.out.println("3>>"+phrase);
        phrase = phrase.replaceAll(",", " OR ").replaceAll("\\+", " AND ").replaceAll("\"-\"", " NOT ");
        return phrase;
    }
    
    private static boolean isNullStr(String str)
    {
        if (str.equals("") || str == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 判断str1中包含str2的个数
     * 
     * @param str1
     * @param str2
     * @return counter
     */
    public static int countStr(String str1, String str2)
    {
        if (str1.indexOf(str2) == -1)
        {
            return 0;
        }
        else if (str1.indexOf(str2) != -1)
        {
            counter++;
            countStr(str1.substring(str1.indexOf(str2) + str2.length()), str2);
            return counter;
        }
        return 0;
    }
}
