// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greet/greet.proto

package com.proto.greet;

public final class Greet {
  private Greet() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_Greeting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_Greeting_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_GreetEveryoneRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_GreetEveryoneRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_GreetEveryoneResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_GreetEveryoneResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021greet/greet.proto\022\005greet\"3\n\010Greeting\022\022" +
      "\n\nfirst_name\030\001 \001(\t\022\023\n\013second_name\030\002 \001(\t\"" +
      "9\n\024GreetEveryoneRequest\022!\n\010greeting\030\001 \001(" +
      "\0132\017.greet.Greeting\"\'\n\025GreetEveryoneRespo" +
      "nse\022\016\n\006result\030\001 \001(\t2`\n\014GreetService\022P\n\rG" +
      "reetEveryone\022\033.greet.GreetEveryoneReques" +
      "t\032\034.greet.GreetEveryoneResponse\"\000(\0010\001B\023\n" +
      "\017com.proto.greetP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_greet_Greeting_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_greet_Greeting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_Greeting_descriptor,
        new java.lang.String[] { "FirstName", "SecondName", });
    internal_static_greet_GreetEveryoneRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_greet_GreetEveryoneRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_GreetEveryoneRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_greet_GreetEveryoneResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_greet_GreetEveryoneResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_GreetEveryoneResponse_descriptor,
        new java.lang.String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
