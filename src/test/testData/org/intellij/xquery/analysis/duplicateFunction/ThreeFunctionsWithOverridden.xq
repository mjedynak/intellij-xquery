<error descr="'test($arg1)' is already defined in 'ThreeFunctionsWithOverridden.xq'">declare function local:test($a)</error> {
    "anyString"
};

<error descr="'test($arg1)' is already defined in 'ThreeFunctionsWithOverridden.xq'">declare function local:test($b)</error> {
    "anyString"
};

declare function local:test($a, $b) {
    "anyString"
};

local:test()
