package com.jiyun.geeknews.base;

public interface BaseCallBack<K, V> {
    void onSuccess(K k);

    void onFail(V v);
}
