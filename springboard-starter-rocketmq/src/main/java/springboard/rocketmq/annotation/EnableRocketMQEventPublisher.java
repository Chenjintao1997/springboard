package springboard.rocketmq.annotation;

import org.springframework.context.annotation.Import;
import springboard.rocketmq.RocketMQEventPublisherConfig;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RocketMQEventPublisherConfig.class)
public @interface EnableRocketMQEventPublisher { }
