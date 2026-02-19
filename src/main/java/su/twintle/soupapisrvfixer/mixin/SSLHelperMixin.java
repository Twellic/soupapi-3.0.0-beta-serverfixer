package su.twintle.soupapisrvfixer.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import padej.soup.core.server.SSLHelper;

@Mixin(SSLHelper.class)
public class SSLHelperMixin {

    @Inject(method = "trustSelfSignedCertificates", at = @At("HEAD"), cancellable = true)
    private static void cancelSSL(CallbackInfo ci) {
        ci.cancel();
    }
}