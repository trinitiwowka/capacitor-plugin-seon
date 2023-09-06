import { WebPlugin } from '@capacitor/core';

import type { PluginSeonPlugin } from './definitions';

export class PluginSeonWeb extends WebPlugin implements PluginSeonPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
