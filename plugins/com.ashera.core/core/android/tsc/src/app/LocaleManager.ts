import { LOCALE_MANAGER_KEYS } from '../Constants';
declare var coreManager: any;

export default class LocaleManager {
	static localeManager: LocaleManager = new LocaleManager();

	private keys: string[] = LOCALE_MANAGER_KEYS;
	private static localeMap: any;
	public static getInstance(): LocaleManager {
		return LocaleManager.localeManager;
	}

	public init() {
		coreManager.executeSimpleCommand([["loadLocale", this.keys]], function (obj: any) {
			LocaleManager.localeMap = JSON.parse(obj)["loadLocale"];
		});
	}

	public translate(key: string) {
		if (LocaleManager.localeMap[key]) {
			return LocaleManager.localeMap[key];
		}

		return key;
	}
}