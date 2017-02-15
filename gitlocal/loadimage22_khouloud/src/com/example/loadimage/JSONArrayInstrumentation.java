package com.example.loadimage;
///*  1:   */ package com.newrelic.agent.android.instrumentation;
///*  2:   */ 
///*  3:   */ /*  4:   */ import java.util.ArrayList;
///*  5:   */ import java.util.Arrays;
//
///*  6:   */ import org.json.JSONArray;
///*  7:   */ import org.json.JSONException;
//
//import com.newrelic.agent.android.tracing.TraceMachine;
///*  8:   */ 
///*  9:   */ public class JSONArrayInstrumentation
///* 10:   */ {
///* 11:15 */   private static final ArrayList<String> categoryParams = new ArrayList<String>(Arrays.asList(new String[] { "category", MetricCategory.class.getName(), "JSON" }));
///* 12:   */   
///* 13:   */   @TraceConstructor
///* 14:   */   public static JSONArray init(String json)
///* 15:   */     throws JSONException
///* 16:   */   {
///* 17:   */     JSONArray jsonArray;
///* 18:   */     try
///* 19:   */     {
///* 20:24 */       TraceMachine.enterMethod("JSONArray#<init>", categoryParams);
///* 21:25 */       jsonArray = new JSONArray(json);
///* 22:26 */       TraceMachine.exitMethod();
///* 23:   */     }
///* 24:   */     catch (JSONException e)
///* 25:   */     {
///* 26:28 */       TraceMachine.exitMethod();
///* 27:29 */       throw e;
///* 28:   */     }
///* 29:32 */     return jsonArray;
///* 30:   */   }
///* 31:   */   
///* 32:   */   @ReplaceCallSite(scope="org.json.JSONArray")
///* 33:   */   public static String toString(JSONArray jsonArray)
///* 34:   */   {
///* 35:37 */     TraceMachine.enterMethod("JSONArray#toString", categoryParams);
///* 36:38 */     String jsonString = jsonArray.toString();
///* 37:39 */     TraceMachine.exitMethod();
///* 38:   */     
///* 39:41 */     return jsonString;
///* 40:   */   }
///* 41:   */   
///* 42:   */   @ReplaceCallSite(scope="org.json.JSONArray")
///* 43:   */   public static String toString(JSONArray jsonArray, int indentFactor)
///* 44:   */     throws JSONException
///* 45:   */   {
///* 46:   */     String jsonString;
///* 47:   */     try
///* 48:   */     {
///* 49:49 */       TraceMachine.enterMethod("JSONArray#toString", categoryParams);
///* 50:50 */       jsonString = jsonArray.toString(indentFactor);
///* 51:51 */       TraceMachine.exitMethod();
///* 52:   */     }
///* 53:   */     catch (JSONException e)
///* 54:   */     {
///* 55:53 */       TraceMachine.exitMethod();
///* 56:54 */       throw e;
///* 57:   */     }
///* 58:57 */     return jsonString;
///* 59:   */   }
///* 60:   */ }
//
////
///* Location:           C:\Users\pc\Downloads\jd-gui-0.3.6.windows\newrelic.android.jar//
// * Qualified Name:     com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation//
// * JD-Core Version:    0.7.0.1//
// */