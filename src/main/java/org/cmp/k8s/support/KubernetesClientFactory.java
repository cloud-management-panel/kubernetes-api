package org.cmp.k8s.support;

import ch.qos.logback.core.util.FileUtil;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

@Configuration
@Profile("prod")
public class KubernetesClientFactory {

    @Bean
    public KubernetesClient kubernetesClient(Config kubeConfig) {
        return new KubernetesClientBuilder().withConfig()
    }

    @Bean
    public Config kubeConfig() {
        return Config.fromKubeconfig()
    }

    @Bean
    public String kubeConfigContent(@Value("cmp.kubeConfig.file") Resource kubeConfigPath) {
        try {

            return kubeConfigPath.getInputStream()
        } catch (IOException e) {
            throw new IllegalArgumentException("kubeConfig file not found!");
        }
        return
    }
}
