package com.github.kacperbieganek;

import static spark.Spark.*;

class NumberConverterApi {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
