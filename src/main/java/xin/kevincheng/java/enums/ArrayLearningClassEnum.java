package xin.kevincheng.java.enums;

import xin.kevincheng.java.consts.ArrayLearningClassConsts;

/**
 * @author kc
 * @title
 * @description The enum ArrayLearningClassEnum is for
 * @date Create in 18:25 2019/11/20
 */
public enum ArrayLearningClassEnum {
    NORMAL_PRIMITIVE_TYPE(ArrayLearningClassConsts.NORMAL_PRIMITIVE_TYPE),
    NORMAL_DEFINED_TYPE(ArrayLearningClassConsts.NORMAL_DEFINED_TYPE);

    private final String type;

    ArrayLearningClassEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
