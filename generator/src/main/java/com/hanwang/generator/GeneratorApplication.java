package com.hanwang.generator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pub.gadfly.sdk.Utils.MybatisPlus;

@SpringBootApplication
public class GeneratorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run( GeneratorApplication.class, args );
	}

	public void run(String[] args){
		// 第一次使用后，代码自动构建完成后请注释后删除掉下面一行！
		MybatisPlus.generator(GeneratorApplication.class);
	}

}
