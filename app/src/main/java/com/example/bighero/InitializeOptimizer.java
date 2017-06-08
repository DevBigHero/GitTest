package com.example.bighero;

/**
 * Created by bighero on 2017/4/24.
 * 1.梳理分析现有流程。移除在主线程之外的多余操作，此过程重点是分析锁，或耗时操作
 * 2。任务分级，对现有流程进行分级，合理并行
 * 3。本地缓存，首页的数据离线化，优先展示本地的缓存数据，等待网络返回之后更新缓存并展示
 * 4。懒加载。对于第一屏无需立刻使用的事物，做到按需加载，等待用户点击时去创建需要的资源
 * 5。网络优化，使用ip直连方式，去除DNS查找的耗时，从而达到优化网络性能的效果
 */

public class InitializeOptimizer {
    /**
     * Application级别，需阻塞启动的任务，如插件、打点、fresco等基础SDK的初始化
     */
    private static boolean sApplicationCreated;
    /**
     * 可延迟到首页加载渲染成功之后再执行的任务，比如splash数据拉取，红包展示等；
     */
    private static boolean sHightSDKInitialized;
    /**
     * 业务懒加载，按需加载，只有在业务使用时才进行初始化的操作。
     */
    private static boolean sLowSDKInitalized;

    public static boolean isApplicationCreated() {
        return sApplicationCreated;
    }

    public static void setApplicationCreated() {
        sApplicationCreated = true;
    }

    public static boolean isHightSDKInitialized() {
        return sHightSDKInitialized;
    }

    public static void setsHightSDKInitialized() {
        sHightSDKInitialized = true;
    }

    public static boolean isLowSDKInitalized() {
        return sLowSDKInitalized;
    }

    public static void setLowSDKInitalized() {
        sLowSDKInitalized = true;
    }
}
