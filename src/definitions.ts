export interface PluginSeonPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
