package com.gildata.xiza.demo.util;

import lombok.extern.slf4j.Slf4j;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.gildata.xiza.demo.constant.CommonConstants.*;

/**
 * @description 正则表达式匹配数字工具类
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
@Slf4j
public class NumberValidationUtil {

        private static boolean isMatch(String regex, String original) {
            if (original == null || "".equals(original.trim())) {
                return false;
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher isNum = pattern.matcher(original);
            return isNum.matches();
        }

        /**
         * 非负整数[0,MAX)
         *
         * @param original
         * @return boolean
         */
        public static boolean isNumeric(String original) {
            return isMatch(REGEX_NUMERIC, original);
        }

        /**
         * 正整数[1,MAX)
         *
         * @param original
         * @return boolean
         */
        public static boolean isPositiveInteger(String original) {
            return isMatch(REGEX_POSITIVE_INTEGER, original);
        }

        /**
         * 负整数 (-MAX,-1]
         *
         * @param original
         * @return boolean
         */
        public static boolean isNegativeInteger(String original) {
            return isMatch(REGEX_NEGATIVE_INTEGER, original);
        }

        /**
         * 整数 (-MAX,MAX)
         *
         * @param original
         * @return boolean
         */
        public static boolean isInteger(String original) {
            return isMatch(REGEX_INTEGER, original);
        }

        /**
         * 正小数 (0.0, MAX)
         *
         * @param original
         * @return boolean
         */
        public static boolean isPositiveDecimal(String original) {
            return isMatch(REGEX_POSITIVE_DECIMAL, original);
        }

        /**
         * 负小数 (-MAX, -0.0)
         *
         * @param original
         * @return boolean
         */
        public static boolean isNegativeDecimal(String original) {
            return isMatch(REGEX_NEGATIVE_DECIMAL, original);
        }

        /**
         * 小数 (-MAX, MAX)
         *
         * @param original
         * @return boolean
         */
        public static boolean isDecimal(String original) {
            return isMatch(REGEX_DECIMAL, original);
        }

        /**
         * 实数，包括所有的整数与小数 (-MAX, MAX)
         *
         * @param original
         * @return boolean
         */
        public static boolean isRealNumber(String original) {
            return isMatch(REGEX_REAL_NUMBER, original);
        }

        /**
         * 实数，包括所有的整数与小数 (-MAX, MAX) + %
         *
         * @param original
         * @return boolean
         */
        public static boolean isRealNumberPercent(String original) { return isMatch(REGEX_REAL_NUMBER_PERCENT, original); }

        /**
         * 非负实数 [0, MAX)
         *
         * @param original
         * @return boolean
         */
        public static boolean isNonNegativeRealNumber(String original) {
            return isMatch(REGEX_NON_NEGATIVE_REAL_NUMBER, original);
        }

        /**
         * 正实数
         *
         * @param original
         * @return boolean
         */
        public static boolean isPositiveRealNumber(String original) {
            return isPositiveDecimal(original) || isPositiveInteger(original);
        }


}
