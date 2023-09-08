import { WebPlugin } from '@capacitor/core';

import type { PluginSeonPlugin } from './definitions';

export class PluginSeonWeb extends WebPlugin implements PluginSeonPlugin {
  getFingerprintBase64(options: {
    sessionId: string
  }): Promise<{
    fp: string;
  }> {
    console.log({sessionId: options.sessionId})
    throw this.unimplemented('Not implemented on web.');
  }
}
