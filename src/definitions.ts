export interface PluginSeonPlugin {
    /**
     * Get fingerprint in Base64 format.
     */
    getFingerprintBase64(options: {
        sessionId: string
    }): Promise<{ fp: string }>;
}
