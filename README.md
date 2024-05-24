修改：
CodeFileName： $!velocityTool.camelCaseName(${question.titleSlug})

TemplateConstant:  
        ${question.content}
        package com.example.leetcode.editor.cn;
        public class $!velocityTool.camelCaseName(${question.titleSlug}){
        public static void main(String[] args) {
             Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        }
             ${question.code}
        }
