package com.example.jedis.contans;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/25
 */
public interface CMSCodeEnum {


    /**
     * 平台名称枚举
     */
    enum PlanNameEnum implements CMSCodeEnum {
        JUTONG( 1, "jutong" ),
        FRESH( 2, "fresh" ),
        SIJI( 3, "siji" );


        private int value;
        private String name;

        PlanNameEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public static CMSCodeEnum getByValue(int value) {
            for (PlanNameEnum o : values( )) {
                if (o.getValue( ) == value) {
                    return o;
                }
            }
            return null;
        }

        public static Integer getByName(String name) {
            for (PlanNameEnum o : values( )) {
                if (o.getName( ).equals( name ) ) {
                    return o.getValue();
                }
            }
            return null;
        }


    }
}
