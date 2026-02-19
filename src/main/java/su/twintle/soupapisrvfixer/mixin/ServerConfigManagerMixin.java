package su.twintle.soupapisrvfixer.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import padej.soup.core.server.ServerConfigManager;

@Mixin(ServerConfigManager.class)
public class ServerConfigManagerMixin {

    @Inject(method = "loadServersFromBackend", at = @At("HEAD"), cancellable = true)
    private static void cancelLoad(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "reloadServersSync", at = @At("HEAD"), cancellable = true)
    private static void cancelReload(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "fetchConfigAsync", at = @At("HEAD"), cancellable = true)
    private static void cancelAsync(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "fetchConfigSync", at = @At("HEAD"), cancellable = true)
    private static void cancelSync(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}