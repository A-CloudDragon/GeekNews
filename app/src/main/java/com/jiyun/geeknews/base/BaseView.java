package com.jiyun.geeknews.base;

public interface BaseView<K,V> {
        void onSuccess(K k);
            void onFail(V v);
}
