package com.example.UserProject.enums;

public enum WeightType {
    LB, KG;

    public static WeightType fromId(int id) {
        switch (id) {
            case 0:
                return LB;
            case 1:
                return KG;
        }
        return null;
    }
}
