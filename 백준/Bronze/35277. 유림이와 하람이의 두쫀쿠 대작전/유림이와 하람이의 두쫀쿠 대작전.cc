#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

static int arr[46] = { 0 };

void solve() {

    int n;
    std::cin >> n;

    int di = 900 + 60 + 600 + 170 + 160 + 110;

    std::cout << n / di;

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}