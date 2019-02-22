package com.shizhan.springcloud.base.basegrammer.importselector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by xiaos 2019/2/19
 * //TODO 写点注释吧
 */
public class MyImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }

}
