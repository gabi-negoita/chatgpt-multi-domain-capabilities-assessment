package ro.ugal.master.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserQueryReference {

    MATHEMATICS_DATASET("https://github.com/deepmind/mathematics_dataset"),
    LGW863_LOGIQA_DATASET("https://github.com/lgw863/LogiQA-dataset"),
    LUCASMCCABE_LOGIQA_DATASET("https://huggingface.co/datasets/lucasmccabe/logiqa"),
    LEETCODE_CODING_PROBLEMS("https://leetcode.com/problemset/all"),
    JAVA_REVISITED_CODING_PROBLEMS("https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html"),
    SQUAD_EXPLORER_DATA_EXTRACTION("https://rajpurkar.github.io/SQuAD-explorer"),
    NO_REFERENCE("no reference");

    @Getter
    @JsonValue
    private final String value;
}
