import java.io.*;
import java.util.*;


%%
%class lab4

%standalone


%{


	HashSet keywords = new HashSet();
	HashSet identifiers = new HashSet();
	HashSet mathOperators = new HashSet();
	HashSet logicalOperators = new HashSet();
	HashSet numericalValues = new HashSet();
	HashSet others = new HashSet();
	HashSet brackets = new HashSet();
	HashSet strings = new HashSet();
	HashSet functions= new HashSet();
    


	public void print_all() {
		System.out.println("Strings: " + strings);
		System.out.println("Keywords: " + keywords);
		System.out.println("Brackets: " + brackets);
		System.out.println("Math Operators: " + mathOperators);
		System.out.println("Fuctions: " + functions);
		System.out.println("Numerical Values: " + numericalValues);
		System.out.println("Identifiers: " + identifiers);
		System.out.println("Logical Operators: " + logicalOperators);
		System.out.println("Others: " + others);
		
	}

%}

%eof{
	print_all();
%eof}

Letters = [a-zA-Z]
Digits = [0-9]
Whitespace = [ \n\t]
MathOp = ["+" | "-" | "/" | "*" | "=" | "++" | "--"]
LogicalOp = [">" | "<" | ">=" | "<=" | "=="]
Br = ["(" | ")" | "{" | "}"]
Oth=[ "," | ";"]

%%

{Whitespace}			{ }

"for"				{keywords.add(yytext());}
"double"			{keywords.add(yytext());}
"float"				{keywords.add(yytext());}
"int"				{keywords.add(yytext());}
"if"				{keywords.add(yytext());}
"else"				{keywords.add(yytext());}
"do"				{keywords.add(yytext());}
"return"			{keywords.add(yytext());}
"while"				{keywords.add(yytext());}


"\"{Letters}"\"			{strings.add(yytext());}
"main"|"System.out.println"	{functions.add(yytext());}
{Letters}({Letters}|{Digits})* 	{identifiers.add(yytext());}
{Br}				{brackets.add(yytext());}
{MathOp}			{mathOperators.add(yytext());}
{LogicalOp}			{logicalOperators.add(yytext());}
{Digits}+			{numericalValues.add(yytext());}
{Digits}+"."{Digits}* 		{numericalValues.add(yytext());}
{Oth}				{others.add(yytext());}
