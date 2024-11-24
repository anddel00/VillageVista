{\rtf1\ansi\ansicpg1252\cocoartf2820
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 .AppleSystemUIFontMonospaced-Regular;}
{\colortbl;\red255\green255\blue255;\red184\green93\blue213;\red155\green162\blue177;\red197\green136\blue83;
\red136\green185\blue102;}
{\*\expandedcolortbl;;\cssrgb\c77647\c47059\c86667;\cssrgb\c67059\c69804\c74902;\cssrgb\c81961\c60392\c40000;
\cssrgb\c59608\c76471\c47451;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\fs26 \cf2 FROM\cf3  openjdk:\cf4 11\cf3 -jdk-slim\
\cf2 WORKDIR\cf3  /app\
\cf2 COPY\cf3  VillageVista-1.0-SNAPSHOT.war /app/app.war\
\cf2 EXPOSE\cf3  \cf4 8080\
\cf2 CMD\cf3  [\cf5 "java"\cf3 , \cf5 "-jar"\cf3 , \cf5 "app.war"\cf3 ]}