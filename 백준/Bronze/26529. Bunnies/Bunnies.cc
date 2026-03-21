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

	arr[0] = 1;
	arr[1] = 1;
    for (int i = 2; i <= 45; ++i) {
        arr[i] = arr[i - 1] + arr[i - 2];
	}

    while (n--) {
        int k;
        std::cin >> k;
        std::cout << arr[k] << '\n';
	}

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}