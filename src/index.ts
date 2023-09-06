import { registerPlugin } from '@capacitor/core';

import type { PluginSeonPlugin } from './definitions';

const PluginSeon = registerPlugin<PluginSeonPlugin>('PluginSeon', {
  web: () => import('./web').then(m => new m.PluginSeonWeb()),
});

export * from './definitions';
export { PluginSeon };
