package ro.ugal.master.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserQueryInputType {

    MATH_ARITHMETIC_DIVISION("math.arithmetic.division"),
    MATH_ARITHMETIC_MULTIPLICATION("math.arithmetic.multiplication"),
    MATH_COMPARISON_SORT("math.comparison.sort"),
    MATH_ALGEBRA_1D("math.algebra.1d"),
    MATH_ALGEBRA_2D("math.algebra.2d"),
    LGW863_LOGICAL("lgw863.logical"),
    LUCASMCCABE_LOGICAL("lucasmccabe.logical"),
    LEETCODE_CODING_PROBLEMS("leetcode.coding-problems"),
    LOGICAL_DEBUGGING_PROBLEMS("debugging-problems.logical"),
    SYNTAX_DEBUGGING_PROBLEMS("debugging-problems.syntax"),
    DATA_EXTRACTION("data.extraction");

    @Getter
    @JsonValue
    private final String value;
}
