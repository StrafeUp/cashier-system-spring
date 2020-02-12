package com.strafeup.cashiersystemspring.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PageUtils {
    private static final Logger LOGGER = LogManager.getLogger(PageUtils.class);

    public static int parsePageNumber(String page, int defaultPage) {
        try {
            return Integer.parseInt(page);
        } catch (NumberFormatException e) {
            LOGGER.warn("Tried to access page with string letters");
        }
        return defaultPage;
    }
}
